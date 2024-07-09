package hw1_customHashMap;

import java.util.LinkedList;
import java.util.List;

public class CustomBucket <K,V> {
    private List<CustomNode<K,V>> list;

    public CustomBucket() {
        list = new LinkedList<>();
    }

    public void add(CustomNode<K,V> cn) {
        if (!isContainKey(cn.getKey())) {
            list.add(cn);
        } else  {
            System.out.println("Already exists key: " + cn.getKey());
        }
    }

    public V get(K key) {
        for (CustomNode<K,V> cn : list) {
            if (cn.getKey() == key) {
                return cn.getValue();
            }
        }
        return null;
    }

    public void delete(K key) {
        list.removeIf(cn -> cn.getKey().equals(key));
    }

    private boolean isContainKey(K key) {
        return list.stream().anyMatch(node -> node.getKey() == key);
    }
}