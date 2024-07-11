package hw1_customHashMap;

import java.util.Objects;

/**
 * This class is required to store the key and value.
 * @param <K> the key by which an object of this class is found.
 * @param <V> the value that is stored in this object, according to this key.
 */
public class CustomNode <K,V> {
    private final K key;
    private V value;

    public CustomNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * The method returns the value of the key of an object of this class.
     * @return key
     */
    public final K getKey() {
        return key;
    }

    /**
     * The method returns the value of an object of this class.
     * @return value
     */
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
