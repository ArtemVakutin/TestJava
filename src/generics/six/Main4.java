package generics.six;

import java.util.Arrays;

public class Main4 {
    static class TestObject <T> {

    }
    static class TestObject2 <T, M extends Number> {

    }

    public static void main(String[] args) {
        TestObject testObject = new TestObject<Integer>();
        TestObject2 testObject2 = new TestObject2<String, Integer>();

        System.out.println(Arrays.toString(testObject.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(testObject2.getClass().getTypeParameters()));
    }



}
