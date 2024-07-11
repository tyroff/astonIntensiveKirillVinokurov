package hw1_customHashMap;

import java.util.LinkedList;
import java.util.List;

/**
 * The class is required to add, store and delete objects of the {@link CustomNode} type in a collection {@link LinkedList}.
 * @param <K> key type in {@link CustomNode}.
 * @param <V> value type in {@link CustomNode}.
 */
public class CustomBucket <K,V> {
    private List<CustomNode<K,V>> list;

    public CustomBucket() {
        list = new LinkedList<>();
    }

    /**
     * The method receives a Node as input. Compares the key of this Node with other Nodes in the leaf.
     * If there is none, it adds it to the {@link LinkedList}, otherwise it does not save it.
     * @param cn {@link CustomNode} that needs to be saved in the {@link LinkedList}.
     */
    public void add(CustomNode<K,V> cn) {
        if (cn.getKey() == null) {
            if (list.isEmpty()) {
                list.add(cn);
            } else {
                System.out.println("Key null already exists into bucket!");
            }
        } else {
            if (!isContainKey(cn.getKey())) {
                list.add(cn);
            } else  {
                System.out.println("Key " + cn.getKey() + " already exists into bucket!");
            }
        }
    }

    /**
     * Based on the key value, it searches for the value of the {@link CustomNode} in the {@link LinkedList}
     * and returns it, otherwise it returns Null.
     * @param key the key value to look up the value.
     * @return value or null.
     */
    public V get(K key) {
        if(key == null) {
            return list.get(0).getValue();
        }
        for (CustomNode<K,V> cn : list) {
            if (cn.getKey().hashCode() == key.hashCode()) {
                return cn.getValue();
            }
        }
        return null;
    }

    /**
     * Deletes a {@link CustomNode} in a {@link LinkedList} based on its key value.
     * @param key the key value.
     */
    public void delete(K key) {
        list.removeIf(cn -> cn.getKey().equals(key));
    }

    /**
     * In the {@link LinkedList}, it searches for {@link CustomNode} with an input key value.
     * @param key the key value.
     * @return if it finds a {@link CustomNode} with such a key, it returns True, otherwise False
     */
    private boolean isContainKey(K key) {
        return list.stream().anyMatch(node -> node.getKey() == key);
    }
}
