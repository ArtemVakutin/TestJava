package lambda;

public interface Reduce <T> {
    T reduce(T t, T m);
}
