package basicgame;

import java.util.Arrays;
import java.util.Objects;

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
                if(i == 0 || i == level.length-1 || j == 0 || j == level.length-1){
                    level[i][j] = "X";
                } else {
                    level[i][j] = " ";
                }
            }
        }
        for(int i = 1; i <= 100; i++) {
            if(i % 10 == 0) {
                //irányváltoztatás
                switch (direction){
                    case RIGHT:
                        direction = Direction.DOWN;
                        break;
                    case DOWN:
                        direction = Direction.LEFT;
                        break;
                    case LEFT:
                        direction = Direction.UP;
                        break;
                    case UP:
                        direction = Direction.RIGHT;
                        break;
                }
            }
            // ez a lépés
            switch(direction) {
                case RIGHT:
                    if(level[row][column+1].equals(" ")) {
                        column++;
                    }
                break;
                case LEFT:
                    if(level[row][column-1].equals(" ")) {
                        column--;
                    }
                break;
                case UP:
                    if(level[row-1][column].equals(" ")){
                        row--;
                    }
                break;
                case DOWN:
                    if(level[row+1][column].equals(" ")) {
                        row++;
                    }
                break;
            }
            //pálya és játékor kirajzolása
            for (int k = 0; k < level.length; k++) {
                for (int j = 0; j < level[k].length; j++) {
                    if (k == row && j == column && !level[k][j].equals("X")) {
                        System.out.print(playerMark);
                    } else {
                        System.out.print(level[k][j]);
                    }
                }
                System.out.println();
            }

            System.out.println("----------");
            Thread.sleep(500L);
        }
    }
    // feladat: 1. pályának legyen egy kerete pl: X
    // 2. bármilyen irányba megy a karakter, ha egy falba ütközik, akkor ne lépjen arra tovább, hanem maradjon egyhelyben
    // 3. minden tizedik lépés után változtasson irányt a karakter - jobbra után legyen lefele, utána balra, utána fölfele, majd jobbra,
    //. játék 100 szor fusson le
}
