package Calculator;

/**
 * Класс составляющий пару значений разного типа. Решение 3
 * @param <V> First
 * @param <T> Second
 */
public class Pair <V, T>{
    private V v;
    private T t;

    public Pair(V v, T t) {
        this.v = v;
        this.t = t;
    }

    public V getFirst() {
        return v;
    }

    public T getSecond() {
        return t;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "v=" + v +
                ", t=" + t +
                '}';
    }
}
