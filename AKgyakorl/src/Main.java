public class Main {
    public static void main(String[] args) {

        int i = 100;
        i++;
        System.out.println(i);

        Integer integer = 100;
        integer++;
        System.out.println(integer);

        int j=100;
        System.out.println(j++); // először kiírja az eredeti értéket majd növeli eggyel - 100-at ír ki és utána 101-re növel
        System.out.println(++j); // először növeli eggyel az értéket majd kiírja - 101-et megnöveli eggyel majd kiírja azt azaz a 102

        int z = 100;
        int k = z++ + ++z; // összeadás jel bal oldalára behelyettesíti a 100-at majd növeli 101-re, az összeadás jel jobb oldalán a 101-et először növeli eggyel majd a növelt értéket
                           //a  102-t helyettesíti be, 100+102=202
        System.out.println(k);
        int e = 999;

        System.out.println(e++ < 1000);
        System.out.println(e);

        // ha rövidzáras operátornál nem megy végig a kifejezésen a művelet pl: b1=false és a kifejezés: b1 && i++<1000 - mivel a falsenál már megáll
        // a kiértékelés hiszen a végeredmény mindenképpen false lesz ezért az i++ nem hajtódik végre így az i értéke ebben az esetben nem lesz megnövelve

        // && helyett & használunk, akkor mindenképpen végigmegy a kiértékelés a teljes kifejezésen, akkor is ha az első false
        int x = 10;
        boolean bool = false; // vagy esetén ha az első érték true akkor rövidre zár és már a másodikat nem is nézi, hiszen a végeredmény mindenképpen true lesz
        boolean result = bool || x++>1;
        System.out.println(result);
        System.out.println(x);


    }
}