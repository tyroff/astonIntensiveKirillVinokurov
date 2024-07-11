package hw1_customHashMapTests;

import hw1_customHashMap.CustomHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomHashMapTest {
    CustomHashMap<String, String> map = new CustomHashMap<>();

    @Test
    public void putTest() {
        map.put("String 1", "String 2");
        assertEquals("String 2", map.get("String 1"));
    }

    @Test
    public void putNullKeyTest() {
        map.put(null, "String");
        assertEquals("String", map.get(null));
    }

    @Test
    public void putManyTest() {
        for(int i=0; i < 20; i++) {
            String key = "Key" + i;
            String value = "Value" + i;
            map.put(key, value);
        }

        for(int i=0; i < 20; i++) {
            String key = "Key" + i;
            String value = "Value" + i;
            assertEquals(value, map.get(key));
        }
    }

    @Test
    public void getTest() {
        map.put("String 1", "String 2");
        assertEquals("String 2", map.get("String 1"));
    }

    @Test
    public void getNullKeyTest() {
        map.put(null, "String");
        assertEquals("String", map.get(null));
    }

    @Test
    public void removeTest() {
        map.put("String 1", "String 2");
        map.remove("String 1");
        assertNull(map.get("String 1"));
    }

    @Test
    public void removeManyTest() {
        for(int i=0; i < 20; i++) {
            String key = "Key" + i;
            String value = "Value" + i;
            map.put(key, value);
        }

        for(int i=0; i < 20; i++) {
            String key = "Key" + i;
            map.remove(key);
            assertNull(map.get(key));
        }
    }
}
