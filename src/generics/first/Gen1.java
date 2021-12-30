package generics.first;

public class Gen1<T extends Animal & Sleepable, E> {
    T tobject;
    E eobject;
    public Gen1() {

    }

    public void print() {
        System.out.println(tobject);
        System.out.println(eobject);
        tobject.sleep();
    }


    public T getTobject() {
        return tobject;
    }

    public void setTobject(T tobject) {
        this.tobject = tobject;
    }

    public E getEobject() {
        return eobject;
    }

    public void setEobject(E eobject) {
        this.eobject = eobject;
    }

    public static void main(String[] args) {
        Gen1<Cat, Integer> gen1 = new Gen1<Cat, Integer>();
        gen1.setTobject(new Cat());
        gen1.setEobject(111);
        gen1.print();

    }
}
