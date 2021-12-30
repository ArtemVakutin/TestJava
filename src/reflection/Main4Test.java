package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main4Test {

        public static void main(String[] args) {
            Class<OneAbstract> manager = OneAbstract.class;
//        Class<TestInterface> manager = TestInterface.class;
            Package aPackage = manager.getPackage();
            System.out.printf("package %s;\n", aPackage.getName());

            // 1010111 // хотим получить первый бит справа
            // & // побитовое И
            // 0000001 // 1
            // ==
            // 0000001 // 1

            // 123 & 1 == правый бит

            // 1010111 // хотим получить второй бит справа
            // & // побитовое И
            // 0000010 // 2
            // ==
            // 0000010 // 2

            // 123 & 2 == второй справа бит

            int modifiers = manager.getModifiers();
//        System.out.println(modifiers);
//        System.out.println(modifiers & 1);
//        System.out.println(Modifier.isPublic(modifiers));

            System.out.printf("%s %s %s ", Modifier.toString(modifiers),
                    manager.isInterface() ? "" : "class",
                    manager.getSimpleName());

            System.out.printf("extends %s implements ",
                    manager.getSuperclass().getSimpleName());

            Class<?>[] interfaces = manager.getInterfaces();

            for (int i = 0; i < interfaces.length; i++) {
                Class<?> anInterface = interfaces[i];
                System.out.print(i == 0 ? "" : ", ");
                System.out.print(anInterface.getSimpleName());
            }

            System.out.println(" {");

            Field[] fields = manager.getDeclaredFields();

            for (Field field : fields) {
                System.out.printf("\t%s %s %s;\n",
                        Modifier.toString(field.getModifiers()),
                        field.getType().getSimpleName(),
                        field.getName());
            }

            System.out.println();

            Constructor<?>[] constructors = manager.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.printf("\t%s %s(%s) {}\n",
                        Modifier.toString(constructor.getModifiers()),
                        manager.getSimpleName(),
                        getParameters(constructor.getParameterTypes()));
            }

            System.out.println();

//        Method[] methods = manager.getMethods();
            Method[] methods = manager.getDeclaredMethods();
            for (Method method : methods) {
                System.out.printf("\t%s %s %s(%s) {}\n",
                        Modifier.toString(method.getModifiers()),
                        method.getReturnType().getSimpleName(),
                        method.getName(),
                        getParameters(method.getParameterTypes()));

            }

            System.out.println("}\n");
        }

        private static String getParameters(Class<?>[] parameters) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < parameters.length; i++) {
                Class<?> parameter = parameters[i];
                result.append(i == 0 ? "" : ", ")
                        .append(parameter.getSimpleName())
                        .append(" param")
                        .append(i);
            }
            return result.toString();
        }
    }

