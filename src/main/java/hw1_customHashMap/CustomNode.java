package hw1_customHashMap;

import java.util.Objects;

public class CustomNode <K,V> {
    private final K key;
    private V value;

    public CustomNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final String toString() {
        return key + " = " + value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomNode<?, ?> that = (CustomNode<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    public int hashCode() {
        return Objects.hash(key, value);
    }
}
