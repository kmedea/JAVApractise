package basicgame;

import java.util.Arrays;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class BasicGame {
    public static void main(String[] args) throws InterruptedException {
        String[][] level = new String[10][10];
        String playerMark = "O";
        int row = 1;
        int column = 1;
        Direction direction = Direction.RIGHT;

        initLevel(level); //pálya inicializálása - a null helyett ez tölti fel a kétdimenziós tömböt szóközzel és X-el

        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                //irányváltoztatás
                direction = changeDirection(direction);
            }
            // ez a lépés
            row = makeMove(direction, level, row, column)[0];
            column = makeMove(direction, level, row, column)[1];
            // kirajzolás
            draw(level, playerMark, row, column);

            System.out.println("----------");
            Thread.sleep(500L);
        }
    }
    // feladat: 1. pályának legyen egy kerete pl: X
    // 2. bármilyen irányba megy a karakter, ha egy falba ütközik, akkor ne lépjen arra tovább, hanem maradjon egyhelyben
    // 3. minden tizedik lépés után változtasson irányt a karakter - jobbra után legyen lefele, utána balra, utána fölfele, majd jobbra,
    //. játék 100 szor fusson le

    static void draw(String[][] board, String mark, int x, int y) {
        for (int k = 0; k < board.length; k++) {
            for (int j = 0; j < board[k].length; j++) {
                if (k == x && j == y && !board[k][j].equals("X")) {
                    System.out.print(mark);
                } else {
                    System.out.print(board[k][j]);
                }
            }
            System.out.println();
        }
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

    static Integer[] makeMove(Direction direction, String[][] level, int row, int column) {
        Integer[] rowAndColumn = new Integer[2];
        int newRow = row;
        int newColumn = column;
        switch (direction) {
            case RIGHT -> {
                if (level[row][column + 1].equals(" ")) {
                    newColumn++;
                }
            }
            case LEFT -> {
                if (level[row][column - 1].equals(" ")) {
                    newColumn--;
                }
            }
            case UP -> {
                if (level[row - 1][column].equals(" ")) {
                    newRow--;
                }
            }
            case DOWN -> {
                if (level[row + 1][column].equals(" ")) {
                    newRow++;
                }
            }
        }
        rowAndColumn[0] = newRow;
        rowAndColumn[1] = newColumn;
        return rowAndColumn;
    }


    //Házi: 1. pálya inicializálását kiemelni külön metódusba a név: initLevel();
    // 2. a karakter mozgatását végző logikát is ki kell emelni egy külön metódusba, neve: makeMove(),
    // bemeneti paraméterként kapja meg a karakter aktuális sor és oszlop adatát, visszatérési értékként adja vissza az új koordinátákat egy int tömben
}
