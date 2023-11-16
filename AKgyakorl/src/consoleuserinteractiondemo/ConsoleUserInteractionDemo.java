package consoleuserinteractiondemo;

import java.util.Scanner;

public class ConsoleUserInteractionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // a System.in a - innen olvassa be az adatokat - a sztenderd bemenet - a billentyűzetről olvas be
        System.out.println("Kérem, adjon meg egy számot:");
        int number = scanner.nextInt(); //egész számot olvas be - a number változót inicializálom a beolvasott értékkel
        scanner.nextLine(); /*amikor beírunk egy számot, akkor a végén entert ütünk, ezt a nextInt() nem olvassa be, ott marad beolvasatlanul az enter karakter,
                             ha utána mondjuk akarunk szöveget bekérni, akkor a nextLine beolvassa az entert és egy üres szöveget irna ki a 19. sorban levő kód
                            ezért ilyen esetben a beolvasás után érdemes egy scanner.nextLine()-t beszúrni */
        System.out.println("A megadott szám: "+number);

        System.out.println("Kérem, adjon meg egy lebegőpontos számot:");
        double myDoubleNumber = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("A megadott szám: "+myDoubleNumber);

        System.out.println("Kérem, adjon meg egy szöveget.");
        String myString = scanner.nextLine();
        System.out.println("A megadott szöveg: "+myString);

        // ha két int számot összeszorzunk és túlmegy a határán akkor ott túlcsordulás történik, egy random számot kapunk értéknek




        scanner.close(); // ha nagyon alaposan akarunk eljárni akkor a végén így kell bezárni a szkennert


    }
}
