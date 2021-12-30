package reflection;

public class Main1Test1 {
    public static void main(String[] args) {
        Class c;
        Class d;
        One one = new One(1);
        c = one.getClass();
        c = One.class;
        System.out.println(c.toString());
        d=Able.class; // interface class
        Able able = new Able() {
            @Override
            public void start() {

            }
        };
        d= able.getClass();
        System.out.println(d.getClass());
        System.out.println(((Able) () -> {
        }).toString());
        System.out.println(d.toGenericString());
        System.out.println("");
        System.out.println(c.toString());
        System.out.println(c.getName());
        System.out.println(c.getCanonicalName());
        System.out.println(c.getSimpleName());
        System.out.println(c.getSuperclass());
    }


}
