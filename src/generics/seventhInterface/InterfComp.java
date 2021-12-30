package generics.seventhInterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class InterfComp<T extends Comparable<T>> implements Minimum <T>{
    T[] t;

    @Override

        public T minimum() {
        Arrays.sort(t);
        return t[0];
    }

    public InterfComp(T[] t) {
        this.t = t;
    }
}
