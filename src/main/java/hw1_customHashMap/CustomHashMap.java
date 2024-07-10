package hw1_customHashMap;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class CustomHashMap <K,V> {

    private int capacity;
    private final int DEFAULT_CAPACITY = 16;
    private final int MAXIMUM_CAPACITY = 1073741824;
    transient List<CustomBucket<K,V>> table;

    public CustomHashMap(){
        capacity = DEFAULT_CAPACITY;
        table = new ArrayList<>();
        createNullTable();
    };

    public CustomHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + capacity);
        }
        if (capacity > MAXIMUM_CAPACITY) {
            this.capacity = MAXIMUM_CAPACITY;
        }
        this.capacity = capacity;
        table = new ArrayList<>();
        createNullTable();
    }

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


    public V get(K key) {
        return table.get(hash(key)).get(key);
    }

    public void put(K key,V value) {
        CustomBucket<K,V> bucket = new CustomBucket<>();
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
                bucket.add(new CustomNode<>(null, value));
            } else {
                if (table.get(0) == null) {
                    bucket = new CustomBucket<>();
                } else {
                    bucket = table.get(0);
                }
                bucket.add(new CustomNode<>(null, value));
                table.set(0, bucket);
            }
        }
    }

    public void remove(K key) {
        table.get(hash(key)).delete(key);
    }

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
