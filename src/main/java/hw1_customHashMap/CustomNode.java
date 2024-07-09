package hw1_customHashMap;
//src.main.java.hw1_customHashMap.CustomNode

import java.util.Map;
import java.util.Objects;

public class CustomNode <K,V> implements Map.Entry {
    private final K key;
    private V value;

    CustomNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    @Override
    public V setValue(Object value) {
        return this.value = (V) value;
    }

    public final String toString() {
        return key + "=" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomNode<?, ?> that = (CustomNode<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
