package test.main.java;

import main.java.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.*;


class ArrayListTest {

    /*
    @BeforeEach
    void setUp() {

    }
    */


    /*
    @AfterEach
    void tearDown() {
    }
    */

    /*
    * Add
    * */
    @Test
    void testInit() {
        ArrayList<String> singleStr = new ArrayList<String>("Hi");
        ArrayList<Integer> singleDigit = new ArrayList<Integer>(5);
        ArrayList<Character> singleChar = new ArrayList<Character>('a');
        ArrayList<String> singleNull = new ArrayList<String>((String) null);

        assertEquals("[Hi]", singleStr.toString());
        assertEquals("[5]", singleDigit.toString());
        assertEquals("[a]", singleChar.toString());
        assertEquals("[NULL]", singleNull.toString());

    }

    @Test
    void add_ExpectedInput() {
        ArrayList<Integer> digits = new ArrayList<Integer>(5);
        digits.add(6);
        assertEquals("[5, 6]", digits.toString());
    }

    @Test
    void add_ExpectedInputs() {
        ArrayList<Integer> digits = new ArrayList<Integer>(5);
        digits.add(6);
        digits.add(10);
        digits.add(-13);
        digits.add(-100);
        digits.add(-8);
        digits.add(4549);
        digits.add(43);
        assertEquals("[5, 6, 10, -13, -100, -8, 4549, 43]", digits.toString());
    }

    @Test
    void add_Null() {
        ArrayList<Integer> digits = new ArrayList<Integer>(5);
        digits.add(3);
        digits.add(100);
        digits.add(null);

        assertEquals("[5, 3, 100, NULL]", digits.toString());
    }


    @Test
    void set_ExpectedInputs() {
        ArrayList<Integer> digits = new ArrayList<Integer>(5);
        digits.add(6);

        digits.set(3, 1);
        digits.set(1, 0);
        digits.set(10, 1);
        assertEquals("[1, 10]", digits.toString());
    }


    @Test
    void set_Null() {
        ArrayList<Integer> digits = new ArrayList<Integer>(5);
        digits.add(3);
        digits.add(100);
        digits.set(null, 1);

        assertEquals("[5, NULL, 100]", digits.toString());
    }




    @Test
    void set_OutOfBounds() {
        ArrayList<Integer> digits = new ArrayList<Integer>(-50);
        digits.add(78);

        //User trying to access array space that doesn't exist internally
        assertThrows(IndexOutOfBoundsException.class,
                () -> digits.set(4,34)
        );

        //internal array exists, but not visible to user
        assertThrows(IndexOutOfBoundsException.class,
                () -> digits.set(4, 3)
        );

        //negative index
        assertThrows(IndexOutOfBoundsException.class,
                () -> digits.set(4, -1)
        );

    }







    @Test
    void get_Expected() {
        ArrayList<Integer> digits = new ArrayList<Integer>(-50);
        digits.add(78);

        digits.get(1);

        assertEquals(78, digits.get(1));
    }


    @Test
    void get_Null() {
        ArrayList<Integer> digits = new ArrayList<Integer>(-50);
        digits.add(78);

        digits.add(null);

        assertEquals(null, digits.get(2));
    }

    @Test
    void get_OutOfBounds() {
        ArrayList<Integer> digits = new ArrayList<Integer>(-50);
        digits.add(78);

        //User trying to access array space that doesn't exist internally
        assertThrows(IndexOutOfBoundsException.class,
                () -> digits.get(34)
        );

        //internal array exists, but not visible to user
        assertThrows(IndexOutOfBoundsException.class,
                () -> digits.get(3)
        );

        //negative index
        assertThrows(IndexOutOfBoundsException.class,
                () -> digits.get(-1)
        );


    }




}