package generics.six;

public class Main5 <T> {
    Class<T> kind;
    T t;
    public Main5(Class<T> kind, T t) {
        this.kind = kind;
        this.t = t;
    }


    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        Main5<Building> main = new Main5<Building>(Building.class, new Building());
        System.out.println(main.f(new Building()));
        System.out.println(main.f(new House()));
        System.out.println(main.t instanceof Building);
        System.out.println(main.t instanceof House);
//        Main5<House> main2 = new Main5<House>(House.class, new House());
//        System.out.println(main2.f(new Building()));
//        System.out.println(main2.f(new House()));
//        System.out.println(main2.t instanceof Building);
//        System.out.println(main2.t instanceof House);
//        Object o = new Object();
//        System.out.println(o instanceof Building);
    }
}

class Building{}
class House extends Building{}

