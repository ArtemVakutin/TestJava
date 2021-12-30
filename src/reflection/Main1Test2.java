package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main1Test2 {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException {

//        One one1 = one.newInstance();
//        One one2 = One.class.newInstance();
//        One one1 = new One(1);
//        one1.start();


        Class<One> one = One.class;
        Method[] methods = one.getMethods();


        System.out.println(one.getMethod("start",null));
        Class[] params = new Class[] {Integer.class};
        System.out.println(one.getMethod("getTen", params));
        System.out.println();
//        System.out.println(one.getField("anInt"));
//        Field[] fields = one.getDeclaredFields(); // через getFields видно только Public, также как и через getfield не вызвать
//        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i]); }

        Field field = one.getDeclaredField("anInt");
        System.out.println(field);
        One one1 = new One(1);
        System.out.println(one1.getAnInt());
        field.setAccessible(true); //необходимо установить модификатор доступа, а потом поменять поле
        field.set(one1, 11);
        System.out.println(one1.getAnInt());



    }

}
