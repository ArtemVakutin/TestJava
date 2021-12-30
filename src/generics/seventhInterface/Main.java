package generics.seventhInterface;

public class Main {
    public static void main(String[] args) {
        String[] s = {"Раз", "Два", "Три"};
        System.out.println(new InterfComp<String>(s).minimum());
        Integer[] i = {2, 1, 3,4,5,6};
        System.out.println(new InterfComp<Integer>(i).minimum());
    }

}
