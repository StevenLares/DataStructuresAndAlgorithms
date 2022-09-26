package test.main.java;

import main.java.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {



    @Test
    void testConstructor() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(789);

        assertEquals("[789]", s.toString());

    }


    @Test
    void testConstructorWithNull() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(null);

        assertEquals("[NULL]", s.toString());

    }


    @Test
    void AppendToTail_ExpectedInputs() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(304);

        s.AppendToTail(2);
        s.AppendToTail(38);
        s.AppendToTail(-102);
        s.AppendToTail(-888);
        s.AppendToTail(45);
        s.AppendToTail(789);

        assertEquals("[304, 2, 38, -102, -888, 45, 789]", s.toString());

    }

    @Test
    void AppendToTail_withNullInputs() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(null);

        s.AppendToTail(2);
        s.AppendToTail(null);
        s.AppendToTail(789);

        assertEquals("[NULL, 2, NULL, 789]", s.toString());

    }


    @Test
    void PrependToHead_ExpectedInputs() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(304);

        s.PrependToHead(2);
        s.PrependToHead(38);
        s.PrependToHead(-102);


        assertEquals("[-102, 38, 2, 304]", s.toString());

    }

    @Test
    void PrependToHead_withNullInputs() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(null);

        s.PrependToHead(2);
        s.PrependToHead(38);
        s.PrependToHead(null);


        assertEquals("[NULL, 38, 2, NULL]", s.toString());

    }



    @Test
    void get_Expected_OneNode() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(null);
        assertEquals(null, s.get(0));
    }

    @Test
    void get_Expected_ThreeNodes() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(304);

        s.AppendToTail(2);
        s.AppendToTail(38);
        assertEquals(2,s.get(1));

    }

    @Test
    void get_OutOfBounds() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(304);

        s.AppendToTail(2);
        s.AppendToTail(38);

        //negative index
        assertThrows(IndexOutOfBoundsException.class,
                () -> s.get(-3)
        );


        //index larger than LinkedList
        assertThrows(IndexOutOfBoundsException.class,
                () -> s.get(4)
        );

    }

    @Test
    void addBeforeHead() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.add(0, 32);

        assertEquals("[32, -42]", s.toString());

    }

    @Test
    void addBetweenTwoNodes() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);
        s.add(1, 123);

        assertEquals("[-42, 123, 29]", s.toString());

    }

    @Test
    void addAfterTwoNodes() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);
        s.add(2, 123);

        assertEquals("[-42, 29, 123]", s.toString());

    }

    @Test
    void addOutOfBounds() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);

        //negative index
        assertThrows(IndexOutOfBoundsException.class,
                () -> s.add(-3, 3)
        );


        //index larger than LinkedList currently has
        //not thrown if it's at the very end of the linkedlist
        assertThrows(IndexOutOfBoundsException.class,
                () -> s.add(3, 100)
        );

    }


    @Test
    void remove_HeadWithNoNeighbors() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(30);
        s.remove(0);

        assertEquals("[NULL]", s.toString());

    }

    @Test
    void remove_HeadWithOneNeighbor() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);
        s.remove(0);

        assertEquals("[29]", s.toString());

    }

    @Test
    void removeNodeBetweenTwoNodes() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);
        s.add(2, 123);
        s.remove(1);

        assertEquals("[-42, 123]", s.toString());

    }

    @Test
    void removeNodeTailNode() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);
        s.add(2, 123);
        s.remove(2);

        assertEquals("[-42, 29]", s.toString());

    }

    @Test
    void removeOutOfBounds() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);
        s.AppendToTail(29);

        //negative index
        assertThrows(IndexOutOfBoundsException.class,
                () -> s.remove(-3)
        );


        //index larger than LinkedList currently has
        //not thrown if it's at the very end of the linkedlist
        assertThrows(IndexOutOfBoundsException.class,
                () -> s.remove(100)
        );

    }

    @Test
    void initHead_ExpectedInputs() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);

        SinglyLinkedList<Integer> t = new SinglyLinkedList<Integer>(null);

        s.remove(0);

        s.initHead(20);

        t.initHead(-34);


        assertEquals("[20]",s.toString());
        assertEquals("[-34]",t.toString());

    }

    @Test
    void initHead_HeadAlreadyInitialized() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(-42);

        assertThrows(IndexOutOfBoundsException.class,
                () -> s.initHead(20)
        );

    }


    @Test
    void initHead_NullInit() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(null);

        assertThrows(IndexOutOfBoundsException.class,
                () -> s.initHead(null)
        );

    }

    @Test
    void initHead_NullInit_andHeadNotEmpty() {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>(63);

        assertThrows(IndexOutOfBoundsException.class,
                () -> s.initHead(null)
        );

    }



}