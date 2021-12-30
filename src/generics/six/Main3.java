package generics.six;

import java.util.Iterator;

public class Main3 extends Main2 implements Iterable<Integer>{

    private int n;
    public Main3(int count) {
        n = count;
    }

    @Override
    public Integer next() {
        return super.next();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return Main3.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i:new Main3(18)) {
            System.out.println(i + " ");
        }
    }
}
