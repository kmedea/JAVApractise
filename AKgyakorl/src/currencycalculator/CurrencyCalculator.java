package currencycalculator;

import java.util.Scanner;

/**
 * Írjunk Java programot, ami bekér a felhasználótól egy pozitív egész számot, majd kiszámoja, hogy ez a pénzösszeg milyen
 * címletekben adható ki úty, hogy a legkevesebb címletet használjuk fel!
 */
public class CurrencyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem, adja meg a pénzösszeget: ");
        int moneyAmount = scanner.nextInt();
        System.out.println("A megadott pénzösszeg: "+moneyAmount);
        // címletek: 20000, 10000, 5000, 2000, 1000, 500, 100, 50, 20, 10, 5
        int[] currencies = {20000, 10000, 5000, 2000, 1000, 500, 100, 50, 20, 10, 5};
        int remainingAmount = moneyAmount;
        int[] pieces = new int[currencies.length];
        for(int i = 0; i<currencies.length; i++){
            pieces[i] = re
        }
    }
}
