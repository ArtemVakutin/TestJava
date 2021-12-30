package generics.fiveInterface;

public class MainCollection <T extends Comparable<T>> implements Maximum<T> {
    @Override
    public T maximum() {
        return null;
    }
}
