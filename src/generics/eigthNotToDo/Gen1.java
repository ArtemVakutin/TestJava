package generics.eigthNotToDo;

public class Gen1<T,V extends Number> {
    T t;
    V v;
    T[] masst;

    public void createObject(){
//        t= new T(); не имеет смысла, так как будет new Object, компилятор не скомпилируется. Соответственно нельзя вызвать конструкторы T и V.
    }

    public void createArray() {
//        masst = new T[100]; тоже нельзя
    }

    public void createClass() {
        Gen1<Integer,Integer> gen1;
        gen1 = new Gen1<>();
//        Gen1<Integer,Integer>[] genmass1; нельзя создать массив ссылок на объекты обобщенного типа
//        genmass1 = new Gen1<Integer,Integer>[100];
        Gen1<?,?>[] genmass1;
        genmass1 = new Gen1<?,?>[100];
    }

    public void set(T t){
        System.out.println("Generic T");
    }

    public void set(Integer t){
        System.out.println("Integer t");
    }
//    public void set(V t){
//        System.out.println("Integer t"); нельзя
//    }

    public static void main(String[] args) {
//        Gen1<Integer, Integer> gen1 = new Gen1<>(); Нельзя
        Gen1<String, Integer> gen1 = new Gen1<>();
        gen1.set(1);
    }

}

//class ThrowException<T> extends Throwable{ generic классы не могут быть потомками от throwable
//
//}
