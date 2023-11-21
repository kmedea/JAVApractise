package basicgame;

import java.util.Arrays;

public class BasicGame {
    public static void main(String[] args) throws InterruptedException {
        String[][] level = new String[10][10];
        String playerMark = "O";
        int row = 1;
        int column = 1;
        Direction direction = Direction.RIGHT;
        //pálya inicializálása
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j <level[i].length; j++) {
                if(i == 0 || i == 9 || j == 0 || j == 9){
                    level[i][j] = "X";
                } else {
                    level[i][j] = " ";
                }
            }
        }
        for(int i = 0; i < 10; i++) {
            switch(direction) {
                case RIGHT: column++;
                break;
                case LEFT: column--;
                break;
                case UP: row--;
                break;
                case DOWN: row++;
                break;
            }
            //pálya és játékor kirajzolása
            for (int k = 0; k < level.length; k++) {
                for (int j = 0; j < level[k].length; j++) {
                    if (k == row && j == column) {
                        System.out.print(playerMark);
                    } else {
                        System.out.print(level[k][j]);
                    }
                }
                System.out.println();
            }

            System.out.println("----------");
            Thread.sleep(1_000L);
        }
    }
    // feladat: 1. pályának legyen egy kerete pl: X
    // 2. bármilyen irányba megy a karakter, ha egy falba ütközik, akkor ne lépjen arra tovább, hanem maradjon egyhelyben
    // 3. minden tizedik lépés után változtasson irányt a karakter - jobbra után legyen lefele, utána balra, utána fölfele, majd jobbra,
    //. játék 100 szor fusson le
}
