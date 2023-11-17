package currencycalculator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Írjunk Java programot, ami bekér a felhasználótól egy pozitív egész számot, majd kiszámoja, hogy ez a pénzösszeg milyen
 * címletekben adható ki úty, hogy a legkevesebb címletet használjuk fel!
 * A bekért pénzösszeg nem lehet negatív, ha negatív, akkor legyen figyelmeztetés és kérjük be újra a pénzösszeget.
 * Ne lehessen megadni olyan számot amit nem tud kifizetni az atm, vagy nullára vagy ötösre végződjön a szám.
 * Végén ne csak a tömb tartalmát írjuk ki, hanem címletenként legyen sor megnevezve a címletet.
 */
public class CurrencyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] currencies = {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
        int[] pieces = new int[currencies.length];
        boolean isPositive = true;
        boolean isValid = true;
        System.out.print("Kérem, adja meg a pénzösszeget: ");
       firstdo:
       do {
            int moneyAmount = scanner.nextInt();
            if (moneyAmount < 0) {
                System.out.println("A megadott összeg nem lehet negatív szám, kérem adja meg újra a pénzösszeget.");
                isPositive = false;
            } else {
                    int remainingAmount = moneyAmount;
                    if (remainingAmount % 5 != 0) {
                        System.out.println("A megadott összeg nullára vagy ötre végződhet, kérem adjon meg megfelelő összeget!");
                        isPositive = false;
                        continue firstdo;
                    } else {
                        for (int i = 0; i < currencies.length; i++) {
                            pieces[i] = remainingAmount / currencies[i];
                            remainingAmount = remainingAmount % currencies[i];
                        }
                        isPositive = true;
                    }
                System.out.println(Arrays.toString(pieces));
            }
       } while (!isPositive);
        }
    }

