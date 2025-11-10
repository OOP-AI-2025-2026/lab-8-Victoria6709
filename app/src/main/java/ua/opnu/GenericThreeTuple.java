package ua.opnu;

public class GenericThreeTuple<T, V, S> {
    private final GenericTwoTuple<T, V> baseTuple;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.baseTuple = new GenericTwoTuple<>(first, second);
        this.third = third;
    }

    public T getFirst() {
        return baseTuple.first;
    }

    public V getSecond() {
        return baseTuple.second;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ", " + third + ")";
    }
}
