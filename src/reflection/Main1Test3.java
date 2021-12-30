package reflection;

import java.lang.reflect.*;

public class Main1Test3 {
    public static void main(String[] args) {
        Class<OneAbstract> manager = OneAbstract.class;
        Package aPackage = manager.getPackage();
        System.out.printf("Package %s \n", aPackage.getName());
        System.out.println(manager.getModifiers());
        System.out.println(manager.getModifiers() & 1); // побитовая маска, сравнивает 1010101 с 000001 и выдает 1 только если 1 совпадает с 1.
        System.out.println(Integer.toBinaryString(1025));
        int modifiers = manager.getModifiers();
        System.out.println(Modifier.isPrivate(modifiers) + " " + Modifier.isPublic(modifiers) + " " + Modifier.isStatic(modifiers));
        Class<?>[] interfaces = manager.getInterfaces();

        for (Class i : interfaces
        ) {
            System.out.println(i.getSimpleName());
        }

        Constructor<?>[] constructors = manager.getConstructors();
        for (Constructor con : constructors) {
            System.out.println(con.getName());
            Parameter[] parameters = con.getParameters();

            for (Parameter par:parameters) {
                System.out.println(par.getType());


            }



            TypeVariable[] typeParameters = con.getTypeParameters();
            for (TypeVariable type: typeParameters) {
                System.out.println(type.getName());
            }



        }


    }
}
