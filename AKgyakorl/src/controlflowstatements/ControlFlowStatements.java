package controlflowstatements;

public class ControlFlowStatements {
    public static void main(String[] args) {
        System.out.println("Szia!");

        // ez a switch utasítás
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Hétfő");
            case 2:
                System.out.println("Kedd");
            case 3:
                System.out.println("Szerda"); // ebben az esetben a 3 lesz a belépési pont és utána ha nem szakítjuk meg a folyamatot, akkor az összes
                                                // következő lehetőséget kiírja
            case 4:
                System.out.println("Csütörtök");
            case 5:
                System.out.println("Péntek");
        }

        switch (dayOfWeek) { // Ha betesszük a break-et utána, akkor csak azt az egy lehetőséget írja ki, amelyiket megadtunk
            case 1:
                System.out.println("Hétfő");
                break;
            case 2:
                System.out.println("Kedd");
                break;
            case 3:
                System.out.println("Szerda");
                break;
            case 4:
                System.out.println("Csütörtök");
                break;
            case 5:
                System.out.println("Péntek");
                break;
        }

        // hasznosl lehet az alábbi esetben:
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Hétköznap");
                break;
            case 6:
            case 7:
                System.out.println("Hétvége");
                break;
        }

        // default a végén - ha semelyikbe sem lép be, akkor a default ág fog lefutni

        //switch kifejezés



        System.out.println("Viszlát!");

    }
}
