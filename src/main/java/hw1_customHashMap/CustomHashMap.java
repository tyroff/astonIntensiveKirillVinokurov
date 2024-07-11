package hw1_customHashMap;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * A custom HashMap data structure that stores elements in a key-value format.
 * The key is the unique number of the element, and the value is the content of the element.
 * For each key, custom HashMap creates its own hash.
 * The key and value can be any object or null.
 * @param <K> key object type
 * @param <V> value object type
 */
public class CustomHashMap <K,V> {
    private int capacity;
    private final int DEFAULT_CAPACITY = 16;
    private final int MAXIMUM_CAPACITY = 1073741824;
    transient List<CustomBucket<K,V>> table;

    /**
     * Default constructor. In which the list of buckets is initialized and filled with null.
     * The default Bucket table size is assigned = 16.
     */
    public CustomHashMap(){
        capacity = DEFAULT_CAPACITY;
        table = new ArrayList<>();
        createNullTable();
    };

    /**
     * Designer with sheet size capacity. It must be greater than the default value and less than the maximum value.
     * In which the list of buckets is initialized and filled with null.
     */
    public CustomHashMap(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            throw new IllegalArgumentException("Illegal initial capacity: " + capacity);
        }
        this.capacity = Math.min(capacity, MAXIMUM_CAPACITY);
        table = new ArrayList<>();
        createNullTable();
    }

    /**
     * Based on the hash value of the key, the Bucket number is calculated.
     * @param key key value.
     * @return bucket index.
     */
    private int hash(K key) {
        if(key == null) {
            return 0;
        } else {
            int hashCode = abs(key.hashCode());
            int index = hashCode % capacity;

            if(index == 0) {
                int hash = hashCode;
                while (index == 0) {
                    hash /= capacity;
                    index = hash % capacity;
                }
            }

            while (index > capacity) {
                index /= 10;
            }

            return index == capacity ? --capacity : index;
        }
    }

    /**
     * Gets the Node value from the key value.
     * @param key key value of {@link CustomNode}.
     * @return the {@link CustomNode} value or null.
     */
    public V get(K key) {
        if (key == null) {
            return table.get(0).get(null);
        }
        return table.get(hash(key)).get(key);
    }

    /**
     * Places a Node with the given key and value. If this key is not in the Bucket being added, it adds it, otherwise it does nothing.
     * @param key key value of {@link CustomNode}.
     * @param value value of {@link CustomNode}.
     */
    public void put(K key,V value) {
        CustomBucket<K,V> bucket;
        if (key != null) {
            int index = hash(key);
            if (table.get(index) == null) {
                bucket = new CustomBucket<>();
            } else {
                bucket = table.get(index);
            }
            bucket.add(new CustomNode<>(key, value));
            table.set(index, bucket);
        } else {
            if(table.get(0) == null) {
                bucket = new CustomBucket<>();
                bucket.add(new CustomNode<>(null, value));
                table.set(0, bucket);
            } else if(table.get(0) != null) {
                System.out.println("Key null already exists into CustomHashMap.");
            }
        }
    }

    /**
     * Deletes a {@link CustomNode} by key and value.
     * @param key key value of {@link CustomNode}.
     */
    public void remove(K key) {
        table.get(hash(key)).delete(key);
    }

    /**
     * Fills the new Lise with null.
     */
    private void createNullTable() {
        for(int i = 0; i <= capacity-1; i++) {
            table.add(null);
        }
    }

    @Override
    public String toString() {
        return "CustomHashMap{" +
                "table=" + table +
                '}';
    }
}
