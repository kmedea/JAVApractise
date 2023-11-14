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
        String nameOfDay = switch (dayOfWeek) {
            case 1 -> "Hétfő";
            case 2 -> "Kedd";
            case 3 -> "Szerda";
            case 4 -> "Csütörtök";
            case 5 -> "Péntek";
            case 6 -> "Szombat";
            case 7 -> "Vasárnap";
            default -> throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        };
        // itt nem kell break-et használnunk, kizáró eseteket írnak le a case-ek
        // for ciklus folyamata:
        // 1. ciklus inicializálása, 2. kilépési feltétel ellenőrzése, 3. ciklusmag végrehajtása, 4. növekmény kifejezés kiértékelése
        // utána visszalépés a kilépési feltétel ellenőrzéséhez - ha true akkor folytatódik a ciklus, ha false, akkor pedig vége lesz a ciklusnak

        //for-each ciklus folyamata:
        //1. ciklus kezdete, 2. van következő elem? ha igen, akkor 3. ciklusváltozó aktualizálása és ciklusmag végrehajtása, ha false, akkor
        // befejezi a ciklust.

        //while ciklus
        int i = 10;
        while (i <13) { //a zárojelben levő rész a ciklusban maradási feltétel kifejezése
            System.out.println(i); // ciklusmagban levő utasítások
            i++;
        }
        // while egy elől tesztelő ciklus, először kiértékel majd végrehajtja a ciklusmagban levő utasításokat
        // folyamata: 1. ciklus kezdete 2. kiértékeli a ciklusban maradási feltételt, ha true, akkor végrehajtódik a ciklusmag utasításai
        // utána újra visszaugrik az elejére és újra kiértékeli a ciklusban maradási feltételt, ha az false lesz, akkor kilép a ciklusból
        int k = 10;
        while(k < 20){
            k++; // itt előbb növelem mint kiíratom, tehát ebben az esetben 11-től 20-ig fogja kiírni a számokat
            System.out.println(k);
        }
        // akkor jó a while ciklus, ha nem gond, ha egyszer sem fut le (mert a ciklusban maradási feltétel egyből false)


        //do-while ciklus - hátul tesztelő ciklus - először végrehajtja a ciklusmagban levő utasításokat, majd ellenőrzi a feltételt,
        // ha a feltétel true, akkor újra végrehajtja a ciklusmagot
        int j = 20;
        do {
            System.out.println(j);
            j += 2;
        } while (j < 26);

        //egész osztás, csak az egész részeket írja ki pl 15/2 = 7 az int esetében mindig ez történik

        // continue utasítás használata
        // csak ciklusmagon belül lehet használni, ennek hatására az aktuális iterációban hátralevő utasításokat kihagyja és ugrik a következő iterációra

        // cimkézetlen continue
        for (int l = 0; l < 20; l++){
            if(l % 2 == 0){ // ha a szám páros, akkor belép az if ciklusmagjába, ott a continue miatt átugorja a for ciklusmagban levő további utasításokat,
                continue;   // és ugrik a az l++-ra majd kiértékeli az l<20- at => csak a páratlan számokat írja ki
            }
            System.out.println(l);
        }

        // címkézett continue
        // cimkével el lehet látni a ciklusokat (névvel látom el a ciklust)
        String[] daysOfWeek = {"H", "K", "Sz"};
        String[] mealsOfDay = {"r", "t", "e", "u", "v"};

        outer: for (String day : daysOfWeek){ // itt a cimke az outer és az inner - kettőspont kell utánuk
            System.out.println(day);
            inner: for (String meal : mealsOfDay){
                System.out.println("yyyyyy");
                if(day.equals("K")){
                    continue outer;        // ha csak a continuet írnám akkor mindig a belső ciklust ismételné (innert), így viszont kilép az outerbe
                                            // leírná 5-ször a sok y-t, így viszont csak egyszer leírja majd jön a SZ kiírása
                }
                System.out.println(meal);
            }
            System.out.println("xxxxxxxx");
        }






        System.out.println("Viszlát!");

    }
}
