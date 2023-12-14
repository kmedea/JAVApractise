package basicgame;

import java.util.Random;

public class BasicGame {

    static final int WIDTH = 15; //osztályváltozók
    static final int HEIGHT = 15;
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        String[][] level = new String[HEIGHT][WIDTH];

        initLevel(level); //pálya inicializálása - a null helyett ez tölti fel a kétdimenziós tömböt szóközzel és X-el
        addRandomWall(level, 3, 2);

        String playerMark = "O";
        int[] playerCoordinates = getRandomStartingCoordinates(level); // 0-dik elemén lesz a sor, első elemén pedig az oszlop
        int playerRow = playerCoordinates[0];
        int playerColumn = playerCoordinates[1];
        Direction playerDirection = Direction.RIGHT;

        String enemyMark = "S";
        int[] enemyCoordinates = getRandomStartingCoordinatesForEnemy(level, playerCoordinates, 10);
        int enemyRow = enemyCoordinates[0];
        int enemyColumn = enemyCoordinates[1];
        Direction enemyDirection = Direction.LEFT;

        String powerUpMark = "*";
        int[] powerUpStartingCoordinates = getRandomStartingCoordinates(level);
        int powerUpRow = powerUpStartingCoordinates[0];
        int powerUpColumn = powerUpStartingCoordinates[1];
        boolean powerUpPresentOnLevel = false;
        int powerUpPresenceCounter = 0;
        int powerUpActiveCounter = 0;
        boolean powerUpActive = false;




// Játék fő ciklusa
        for (int i = 1; i <= 100; i++) {
            // játékos léptetése
           if(powerUpActive){
               playerDirection = changeDirectionTowards(level, playerDirection, playerRow, playerColumn, powerUpRow, powerUpColumn);
           } else {
               if (i % 15 == 0) {
                   //irányváltoztatás
                   playerDirection = changeDirection(playerDirection);
               }
           }
            // ez a lépés
            playerRow = makeMove(playerDirection, level, playerRow, playerColumn)[0];
            playerColumn = makeMove(playerDirection, level, playerRow, playerColumn)[1];


            // ellenfél irányváltoztatás
            if(powerUpActive){
                Direction directionTowardsPlayer = changeDirectionTowards(level, enemyDirection, enemyRow, enemyColumn, playerRow, playerColumn);
                enemyDirection = getEscapeDirection(level, enemyRow, enemyColumn, directionTowardsPlayer);
            }
            enemyDirection = changeDirectionTowards(level, enemyDirection, enemyRow, enemyColumn, playerRow, playerColumn);

            // az ellenfél legyen fele olyan gyors mint a játékos
            if(i % 2 == 0) {
                enemyRow = makeMove(enemyDirection, level, enemyRow, enemyColumn)[0];
                enemyColumn = makeMove(enemyDirection, level, enemyRow, enemyColumn)[1];
            }
            //power-up frissítése
            if(powerUpActive){
                powerUpActiveCounter++;
            } else {
                powerUpPresenceCounter++;
            }

            if(powerUpPresenceCounter >= 20) {
                if (powerUpPresentOnLevel) {
                    powerUpStartingCoordinates = getRandomStartingCoordinates(level);
                    powerUpRow = powerUpStartingCoordinates[0];
                    powerUpColumn = powerUpStartingCoordinates[1];
                }
                powerUpPresentOnLevel = !powerUpPresentOnLevel;
                powerUpPresenceCounter = 0;
            }

            //játékos-power-up interakció lekezelése
            if(powerUpPresentOnLevel && playerRow == powerUpRow && playerColumn == powerUpColumn) {
                powerUpActive = true;
                powerUpPresentOnLevel = false;
                powerUpPresenceCounter = 0;
            }

            // kirajzolás
            draw(level, playerMark, playerRow, playerColumn, enemyMark, enemyRow, enemyColumn, powerUpMark, powerUpRow, powerUpColumn, powerUpPresentOnLevel);
            addSomeDelay(500L);
            if (playerRow == enemyRow && playerColumn == enemyColumn) {
                break;
            }
        }
        System.out.println("Játék vége!");
    }

    static Direction getEscapeDirection(String[][] level, int enemyRow, int enemyColumn, Direction directionTowardsPlayer) {
        Direction escapeDirection = getOppositeDirection(directionTowardsPlayer);
        switch (escapeDirection){
            case UP:
            if(level[enemyRow-1][enemyColumn].equals(" ")){
                return escapeDirection;
            } else if (level[enemyRow][enemyColumn-1].equals("")){

            }
            case DOWN:
                if(level[enemyRow+1][enemyColumn].equals(" ")){
                    return escapeDirection;
                }
            case RIGHT:
                if(level[enemyRow][enemyColumn+1].equals(" ")){
                    return escapeDirection;
                }
            case LEFT:
                if(level[enemyRow][enemyColumn-1].equals(" ")){
                    return escapeDirection;
                }
        }

    }

    static Direction getOppositeDirection(Direction direction) {
        switch (direction){
            case UP: return Direction.DOWN;
            case DOWN: return Direction.UP;
            case LEFT: return Direction.RIGHT;
            case RIGHT: return Direction.LEFT;
            default: return direction;
        }
    }

    static int[] getRandomStartingCoordinatesForEnemy(String[][] level, int[] playerCoordinates, int distance) {
        int playerStartingRow = playerCoordinates[0];
        int playerStartingColumn = playerCoordinates[1];
        int randomRow;
        int randomColumn;
        int counter = 0;
        do {
            randomRow = random.nextInt(HEIGHT);
            randomColumn = random.nextInt(WIDTH);
        } while (counter++ < 1_000 // ne kerüljönk bele egy végtelen ciklusba
                && (!level[randomRow][randomColumn].equals(" ") || calculateDistance(randomRow, randomColumn, playerStartingRow, playerStartingColumn)<distance));
        return new int[] {randomRow, randomColumn};
    }

    static int calculateDistance(int row1, int column1, int row2, int column2) {
        int rowDifference = Math.abs(row1 - row2);
        int columnDifference = Math.abs(column1 - column2);
        return (rowDifference+columnDifference);
    }


    static int[] getRandomStartingCoordinates(String[][] level) {
        int randomRow;
        int randomColumn;
       do {
           randomRow = random.nextInt(HEIGHT);
           randomColumn = random.nextInt(WIDTH);
       } while (!level[randomRow][randomColumn].equals(" "));
        return new int[] {randomRow, randomColumn};
    }

    static Direction changeDirectionTowards(String[][] level, Direction originalEnemyDirection, int enemyRow, int enemyColumn, int playerRow, int playerColumn) {
        if(playerRow<enemyRow && level[enemyRow-1][enemyColumn].equals(" ")){
            return Direction.UP;
        }
        if(playerRow>enemyRow && level[enemyRow+1][enemyColumn].equals(" ")){
            return Direction.DOWN;
        }
        if(playerColumn<enemyColumn && level[enemyRow][enemyColumn-1].equals(" ")){
            return Direction.LEFT;
        }
        if(playerColumn>enemyColumn && level[enemyRow][enemyColumn+1].equals(" ")){
            return Direction.RIGHT;
        }
        return originalEnemyDirection;
    }

    static void initLevel(String[][] level) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (i == 0 || i == level.length - 1 || j == 0 || j == level.length - 1) {
                    level[i][j] = "X";
                } else {
                    level[i][j] = " ";
                }
            }
        }
    }

    static void addRandomWall(String[][] level, int numberOfHorizontalWalls, int numberOfVerticalWalls) {
        for (int i = 0; i < numberOfHorizontalWalls; i++) {
            addHorizontalWall(level);
        }
        for (int i = 0; i < numberOfVerticalWalls; i++) {
            addVerticalWall(level);
        }
    }

    static void addHorizontalWall(String[][] level) {
        int wallWidth = random.nextInt(WIDTH - 3) + 1; // ha adunk határt, akkor a 0 és az adott számnál eggyel kisebb számig sorsol
        int wallRow = random.nextInt(HEIGHT - 2) + 1;
        int wallColumn = random.nextInt(WIDTH - 2 - wallWidth);
        for (int i = 0; i < wallWidth; i++) {
            level[wallRow][wallColumn + i] = "X";
        }
    }

    static void addVerticalWall(String[][] level) {
        int wallHeight = random.nextInt(HEIGHT - 3) + 1; // ha adung határt, akkor a 0 és az adott számnál eggyel kisebb számig sorsol
        int wallRow = random.nextInt(HEIGHT - 2 - wallHeight);
        int wallColumn = random.nextInt(WIDTH - 2) + 1;
        for (int i = 0; i < wallHeight; i++) {
            level[wallRow + i][wallColumn] = "X";
        }
    }

    static Integer[] makeMove(Direction direction, String[][] level, int row, int column) { // pass by value - érték átadás történik a paraméter változóknak (javaban mindig csak érték átadás történik a paraméter változóknál)
        switch (direction) {
            case RIGHT -> {
                if (level[row][column + 1].equals(" ")) {
                    column++;
                }
            }
            case LEFT -> {
                if (level[row][column - 1].equals(" ")) {
                    column--;
                }
            }
            case UP -> {
                if (level[row - 1][column].equals(" ")) {
                    row--;
                }
            }
            case DOWN -> {
                if (level[row + 1][column].equals(" ")) {
                    row++;
                }
            }
        }
        return new Integer[]{row, column};
    }

    static Direction changeDirection(Direction direction) {
        switch (direction) {
            case RIGHT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.UP;
            case UP -> direction = Direction.RIGHT;
        }
        return direction;
    }

    static void draw(String[][] board, String mark, int x, int y, String enemyMark, int enemyRaw, int enemyColumn, String powerUpMark, int powerUpRow, int powerUpColumn, boolean powerUpPresent) {
        for (int k = 0; k < board.length; k++) {
            for (int j = 0; j < board[k].length; j++) {
                if (k == x && j == y && !board[k][j].equals("X")) {
                    System.out.print(mark);
                } else if (k == enemyRaw && j == enemyColumn && !board[k][j].equals("X")) {
                    System.out.print(enemyMark);
                } else if (powerUpPresent && k == powerUpRow && j == powerUpColumn) {
                    System.out.print(powerUpMark);
                } else {
                    System.out.print(board[k][j]);
                }
            }
            System.out.println();
        }
    }

    static void addSomeDelay(long timeout) throws InterruptedException {
        System.out.println("----------");
        Thread.sleep(timeout);
    }
    // feladat: 1. pályának legyen egy kerete pl: X
    // 2. bármilyen irányba megy a karakter, ha egy falba ütközik, akkor ne lépjen arra tovább, hanem maradjon egyhelyben
    // 3. minden tizedik lépés után változtasson irányt a karakter - jobbra után legyen lefele, utána balra, utána fölfele, majd jobbra,
    //. játék 100 szor fusson le


    //Házi: 1. pálya inicializálását kiemelni külön metódusba a név: initLevel();
    // 2. a karakter mozgatását végző logikát is ki kell emelni egy külön metódusba, neve: makeMove(),
    // bemeneti paraméterként kapja meg a karakter aktuális sor és oszlop adatát, visszatérési értékként adja vissza az új koordinátákat egy int tömbben
    // 3. ha az ellenfél koordinátája megegyezik a játékos koordinátájával, akkor álljon le és írja ki, hogy játék vége
    // 4. legyen valahol egy függőleges és egy vízszintes fal a pályán belül ennek elhelyezését egy külön metódus végezze

    //Házi: 1. két függőleges és három vízszintes fal véletlenszerű generálása
    // 2. a játékos és az ellenfél véletlenszerűen legyen elhelyezve a pályán, úgy hogy ne kerüljenek falra és ne kerüljenek egymáshoz túl közel
    // legalább tíz lépés távolságra legyenek egymástól
    // 3. power-up a csillag karakter jelképezze - minden 20. iterációban kerüljön pályára véletlenszerűen egy power-up. Ha a power-up-ra rálép a játékos
    // akkor az ellenfél menekülni kezd, vagyis mindig elfele lép tőle, megpróbál minél távolabb kerülni a játékostól.
    // Ha a játékos a power-uphatása alatt elkapja az ellenfelet, akkor nyer. Ezt egy külön üzenettel jelezzük és a játék érjen véget!
    // A power up csak 20 lépésig aktív miután a játékos felvette után a ahatása megszűnik, az ellenfél újra a játékos irányába lépjen.
    //Ha a power-up-ot a játékos felveszi, akkor ezt egy rövid üzenet jelezze minden olyan körben, amikor még akítv a hatása. Ha a játékos nem veszi fel a power-upot 20 körön keresztül,
    // akkor tűnjön el 20 körre, majd 20 kör után megint jelenjen meg véletlenszerűen valahol a pályán (de ne a falba!)
    // A játékos ne csak körbe körbe menjen ha van power-up a pályán, hanem próblja meg felvenni. Ha felvette, akor próbálja meg elkapni az ellenfelet.

}
