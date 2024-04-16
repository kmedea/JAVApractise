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

    Date birthday; - deklarálunk egy Date típusú változót - ekkor egy helyet lefoglal a memóriában (ua. mint a primitívnél)
    birthday = new Date(); - itt van nagy különbség - az egyenlőség jel az értékadás operátor - ennek a legalacsonyabb a precedenciája, így ez értékelődik ki utoljára
                             ezért előszőr a jobb oldal értékelődik ki azaz egy Date objektum jön létre - azaz keres egy új helyet a memóriában ahol létre tud jönni -
                             ez a heap területen jön létre (nagyobb helyet foglal, mint a birthday memóriahelye, mert több adatot foglal 3*4 byte (year,month,day) -
                             néhány byte-tal több, mert egyéb információkat is nyilvántart magáról az objektum,
                             a new operátor visszatérési értéke a most létrejött Date objektum címe (elérési helye a memóriában) - az egyenlőség operátor jobb oldalán ez a cím lesz
                             A birthday változóban a létrejött Date objektum címének bináris értéke tárolódik el - a birthday változó rámutat az újonnan létrejött Date objektumra
                             azért referencia típusú változó, mert ezekben csak egy cím, egy referencia érték tárolódik el, hogy hol található a mi objektumunk
    birthday.year = 2020; - a birthday változón keresztül elérem a Date objektum year mezőjének memóriaterületét és oda beíródik a 2020 bináris változata
    birthday.month = 6;
    birthday.day = 29;
     */

    /* egységbezárás:
    értékek és hozzájuk tartozó műveletek egységbe zárása
     */

}
