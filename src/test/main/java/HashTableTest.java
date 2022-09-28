package test.main.java;

import main.java.Exceptions.keyDoesntExistException;
import main.java.Exceptions.keyExistsException;
import main.java.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void keyExists_andKeyActuallyExists() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(1);
        h1.add("hello", 3);
        
        HashTable h2 = new HashTable();
        h2.add("hello", 3);
        
        assertEquals(true,h1.keyExists("hello"));
        assertEquals(true,h2.keyExists("hello"));



    }

    @Test
    void keyExists_andKeyDoesntExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(1);
        HashTable h2 = new HashTable();

        assertEquals(false,h1.keyExists("hello"));
        assertEquals(false,h2.keyExists("hello"));

    }



    @Test
    void add_keyExists() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);

        h1.add("hello", 3);
        h1.add("world", 100);
    
        

        HashTable h2 = new HashTable();
        
        h2.add("hello", 3);
        h2.add("world", 100);


        assertEquals(3, h1.getValue("hello"));
        assertEquals(100, h1.getValue("world"));

        assertEquals(3, h2.getValue("hello"));
        assertEquals(100, h2.getValue("world"));


    }


    @Test
    void add_keyAlreadyExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(1);

        h1.add("hello", 3);
        h1.add("hello", 100);
            

        HashTable h2 = new HashTable();

        h2.add("hello", 3);
        h2.add("hello", 100);
            



        assertEquals(3, h1.getValue("hello"));

        assertEquals(3, h2.getValue("hello"));



    }

    @Test
    void update_keysExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);

        h1.add("hello", 3);
        h1.update("hello", 3002);

        HashTable h2 = new HashTable();

        h2.add("hello", 3);
        h2.update("hello", 100);



        assertEquals(3002, h1.getValue("hello"));
        assertEquals(100, h2.getValue("hello"));




    }


    @Test
    void update_keysDontExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);

        h1.add("hello", 3);
        h1.update("hi", 3002);

        HashTable h2 = new HashTable();

        h2.add("hello", 3);
        h2.update("hi", 100);


        assertThrows(IndexOutOfBoundsException.class,
        () -> h1.getValue("hi")
        );


        assertThrows(IndexOutOfBoundsException.class,
        () -> h2.getValue("hi")
        );



    }

    @Test
    void remove_keysExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(3);
        
        h1.add("hello", 3);
        h1.remove("hello");

        HashTable h2 = new HashTable();

        h2.add("hello", 3);
        h2.remove("hello");

        assertEquals("[null, null, null]", h1.toString());
        assertEquals("[null, null, null, null, null, null, null, null, null, null, null]", h2.toString());

    }


    @Test
    void remove_keysDontExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(3);
        
        h1.add("hello", 3);
            

        System.out.println(h1.toString());
        h1.remove("helo");
        System.out.println(h1.toString());

        HashTable h2 = new HashTable();

        h2.add("hello", 5);
            

        System.out.println(h2.toString());
        h2.remove("helo");
        System.out.println(h2.toString());




    }

    @Test
    void getValue_keysExist() throws keyExistsException, keyDoesntExistException {
    }

    @Test
    void getValue_keysDontExist() throws keyExistsException, keyDoesntExistException {
        
    }


}