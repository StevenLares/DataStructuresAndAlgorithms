package test.main.java;

import main.java.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void keyExists_andKeyActuallyExists() {
        HashTable h = new HashTable();
        h.add("hello", 3);
        assertEquals(true,h.keyExists("hello"));



    }

    @Test
    void keyExists_andKeyDoesntExist() {
        HashTable h = new HashTable();
        assertEquals(false,h.keyExists("hello"));

    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }

    @Test
    void getValue() {
    }
}