package hw1_customHashMapTests;


import hw1_customHashMap.CustomNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomNodeTest {
    CustomNode<String, Integer> node;
    CustomNode<String, Integer> nodeNull;

    @BeforeEach
    void init() {
        node = new CustomNode<>("First", 1);
        nodeNull = new CustomNode<>(null, null);
    }

    @Test
    public void createTest() {
        assertEquals("First", node.getKey());
        assertEquals(1, node.getValue());
    }

    @Test
    public void getKeyTest() {
        assertEquals(node.getKey(), "First");
    }

    @Test
    public void getValueTest() {
        assertEquals(node.getValue(), 1);
    }

    @Test
    public void createNullTest() {
        assertNull(nodeNull.getKey());
        assertNull(nodeNull.getValue());
    }

    @Test
    public void getKeyNullTest() {
        assertNull(nodeNull.getKey());
    }

    @Test
    public void getValueNullTest() {
        assertNull(nodeNull.getValue());
    }

    @Test
    public void getKeyNotNullTest() {
        assertNotNull(node.getKey());
    }

    @Test
    public void getValueNotNullTest() {
        assertNotNull(node.getValue());
    }
}
