package OOP;

public class PassByValueDemo {
    public static void main(String[] args) {
        int test = 42;
        System.out.println("test értéke: "+test);
        tryToModify(test);
        System.out.println("test értéke: "+test);

        Date testDate = new Date();
        testDate.year = 2020;
        testDate.month = 7;
        testDate.day = 4;
        System.out.println(testDate.year);
        System.out.println(testDate.month);
        System.out.println(testDate.day);

        tryToModifyDate(testDate); /* értékátadás során a referencia cím értéke másolódik be a masikTestDate paraméter változóba - azaz a cím másolódott be
        - a másikTestDate is ugyanarra a területre fog így mutatni mint a testDate változó - ezért a változtatás ugyanazon a területen levő értékeken történik, így
        tudjuk az objektum állapotát módosítani
        Nem az egész objektumot másolja, hanem csak a címet - így viszont a változtatások a metódushívás után is látszanak!
        */

        System.out.println(testDate.year);
        System.out.println(testDate.month);
        System.out.println(testDate.day);

    }

    static void tryToModifyDate(Date masikTestDate) {
        masikTestDate.year = 2021;
        masikTestDate.month = 9;
        masikTestDate.day = 20;
    }

    static void tryToModify(int masikTest) {
        masikTest = 52; // ez a test nem a fönti test - ez csak egy helyi változó
    }

    /* a tryToModify masikTest változója egy paraméter változó - ez a 11. sorban jön létre
    amikor a hetedik sorban átadjuk neki a test változót - akkor a test változó értékét a 42-őt adjuk át - ezért pass by value
    ez az érték másolódik át a masikTest-be azaz mindkettő változó értéke 42 - én a másolat értékét változtatom meg 52-re
    mivel értékét nem adom vissza, így ez a másolat elvész ha vége a metódusnak és a 8. sorban már csak a test változó létezik
    */



}
