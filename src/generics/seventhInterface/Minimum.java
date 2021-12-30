package generics.seventhInterface;

public interface Minimum<T extends Comparable<T>> {

    T minimum();
}
