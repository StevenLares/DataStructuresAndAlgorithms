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
        h2.add("hello", 32);
        
        assertEquals(true,h1.keyExists("hello"));
        assertEquals(true,h2.keyExists("hello"));
        assertEquals(3, h1.getValue("hello"));
        assertEquals(32, h2.getValue("hello"));



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


        HashTable h2 = new HashTable();

        h2.add("hello", 100);



        assertThrows(keyExistsException.class,
                () -> h1.add("hello", -4354)
        );

        assertThrows(keyExistsException.class,
                () -> h2.add("hello", -352)
        );

        assertEquals(3, h1.getValue("hello"));
        assertEquals(100, h2.getValue("hello"));




    }

    @Test
    void update_keysExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);

        h1.add("hello", 3);
        h1.update("hello", 3002);

        HashTable h2 = new HashTable();

        h2.add("hello", 100);
        h2.update("hello", 592);



        assertEquals(3002, h1.getValue("hello"));
        assertEquals(592, h2.getValue("hello"));




    }


    @Test
    void update_keysDontExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);

        h1.add("hello", 3);


        HashTable h2 = new HashTable();

        h2.add("hello", 9);



        assertThrows(keyDoesntExistException.class,
        () -> h1.update("helo", 3002)
        );


        assertThrows(keyDoesntExistException.class,
        () -> h2.update("helo", 100)
        );

        assertEquals(3, h1.getValue("hello"));
        assertEquals(9, h2.getValue("hello"));




    }


    @Test
    void remove_keysExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);

        h1.add("hello", 3);
        h1.remove("hello");

        HashTable h2 = new HashTable();

        h2.add("hello", 332);
        h2.remove("hello");

        assertEquals(false, h1.keyExists("hello"));
        assertEquals(false, h2.keyExists("hello"));

    }



    @Test
    void remove_keysDontExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);
        h1.add("hello", 3);

        HashTable h2 = new HashTable();
        h2.add("hello", 5);


        assertThrows(keyDoesntExistException.class,
                () -> h1.remove("helo")
        );

        assertThrows(keyDoesntExistException.class,
                () -> h2.remove("helo")
        );




    }



    @Test
    void getValue_keysDontExist() throws keyExistsException, keyDoesntExistException {
        HashTable h1 = new HashTable(6);
        HashTable h2 = new HashTable();



        assertThrows(keyDoesntExistException.class,
                () -> h1.getValue("hello")
        );

        assertThrows(keyDoesntExistException.class,
                () -> h2.getValue("hello")
        );

    }


}