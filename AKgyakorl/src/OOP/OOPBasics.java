package OOP;

public class OOPBasics {

    /* OOP -  Object Oriented Programming
    - egységbezárás - encapsulation: az összetartozó részeket egy helyre írjuk - tagoljuk a program részeket
    - öröklődés - inheritance - az öröklődés lehetővé teszi azt, hogy újra lehessen hasznosítani a már megírt kódunkat
    - polimorfizmus - polymorphism - sokalakuság - vannak olyan kódrészletek, amelyek nagyon hasonlóak és különböző szituációkban, különböző típusokat kell használni.
    - absztrakció - abstraction - Az absztrakció azt jelenti, hogy azonosítjuk valaminek a fő, legjelentősebb jellemzőit, miközben egyidejűleg elvetünk minden kisebbet és jelentéktelent.

     https://codegym.cc/hu/groups/posts/hu.155.oop-alapelvek
     */

    /*Pass by value !!!

    érték szerinti átadás - a java csak így működik
    amikor a program egyik része át akar egy másik résznek adni egy értéket, akkor hogyan tudja ezt megtenni
    a java mindig értéket fog átadni
     */

    /*Primitív típusú változónál:
    int year; deklaráljuk a változót - ennek hatására a memóriában létre jön egy int típusú year nevű változó - az int 32 bites ezért 4 byte-ot foglalódik le a memóriában
    ott fog ez létrejönni, ahol van szabad hely, arra nincs ráhatásunk, hogy hol hozza létre a memóriában

    year = 2020; értéket adunk neki - a jobboldal értéke belemásolódik a baloldal értékébe - a 2020 bináris változata kerül be a memóriaterületre
     */

    /*Referencia típusú változóknál:
    class Date {
        int year;
        int month;
        int day;
        }

    Date birthday; - deklarálun egy Date típusú változót - ekkor egy helyet lefoglal a memóriában (ua. mint a primitívnél)
    birthday = new Date(); -
    birthday.year = 2020;
    birthday.month = 6;
    birthday.day = 29;



     */

}
