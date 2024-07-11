package hw1_customHashMapTests;

import hw1_customHashMap.CustomBucket;
import hw1_customHashMap.CustomNode;
import org.junit.jupiter.api.Test;

import javax.management.openmbean.KeyAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomBucketTest {
    CustomBucket<String, Integer> bucket = new CustomBucket<>();

    @Test
    public void addTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", 1);
        bucket.add(node);
        assertEquals(node.getValue(), bucket.get("String"));
    }

    @Test
    public void addNotNullValueTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", 1);
        bucket.add(node);
        assertNotNull(node.getValue());
    }


    @Test
    public void addNotNullKeyTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", 1);
        bucket.add(node);
        assertNotNull(node.getKey());
    }

    @Test
    public void addNullValueTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", null);
        bucket.add(node);
        assertNull(node.getValue());
    }


    @Test
    public void addNullKeyTest() {
        CustomNode<String, Integer> node = new CustomNode<>(null, 1);
        bucket.add(node);
        assertNull(node.getKey());
    }

    @Test
    public void addDuplicateKeyTest() throws KeyAlreadyExistsException {
        CustomNode<String, Integer> node = new CustomNode<>("String", 1);
        CustomNode<String, Integer> duplicateNode = new CustomNode<>("String", 1);
        bucket.add(node);
        Throwable throwable = assertThrows(KeyAlreadyExistsException.class, () -> {
            bucket.add(duplicateNode);
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void addManyTest() {
        for(int i = 0; i < 20; i++) {
            String key = "String" + i;
            Integer value = i;
            bucket.add(new CustomNode<>(key, value));
        }
        assertNotNull(bucket);
    }

    @Test
    public void getTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", 1);
        bucket.add(node);
        assertEquals(1, bucket.get("String"));
    }

    @Test
    public void getNullTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", null);
        bucket.add(node);
        assertNull(bucket.get("String"));
    }

    @Test
    public void getNoNullTest() {
        CustomNode<String, Integer> node = new CustomNode<>("String", 1);
        bucket.add(node);
        assertNotNull(bucket.get("String"));
    }

    @Test
    public void deleteTest() {
        bucket.add(new CustomNode<>("String", 1));
        assertEquals(1, bucket.get("String"));
        bucket.delete("String");
        assertEquals(null, bucket.get("String"));
    }
}
