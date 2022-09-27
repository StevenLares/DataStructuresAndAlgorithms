package test.main.java;

import main.java.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add() {
        Queue<String> q = new Queue<String>("hello");
        q.add("world");

        assertEquals("[hello, world]", q.toString());
    }

    @Test
    void addToNull() {
        Queue<String> q = new Queue<String>(null);
        q.add("world");

        assertEquals("[NULL, world]", q.toString());
    }

    @Test
    void remove() {
        Queue<String> q = new Queue<String>("hello");
        q.add("world");
        q.add("all who inhabit it!");


        q.remove();

        assertEquals("[world, all who inhabit it!]", q.toString());

    }

    @Test
    void removeNull() {
        Queue<String> q = new Queue<String>(null);
        q.add("world");
        q.add("all who inhabit it!");


        q.remove();

        assertEquals("[world, all who inhabit it!]", q.toString());

    }


    @Test
    void peek() {
        Queue<String> q = new Queue<String>("hello");
        q.add("world");
        q.add("all who inhabit it!");


        assertEquals("hello", q.peek());

    }

    @Test
    void peekNull() {
        Queue<String> q = new Queue<String>(null);
        q.add("world");
        q.add("all who inhabit it!");


        assertEquals(null, q.peek());

    }

    @Test
    void isEmpty() {
        Queue<String> q = new Queue<String>(null);

        assertEquals(true, q.isEmpty());

    }


    @Test
    void isEmpty_OnlyHeadNull() {
        Queue<String> q = new Queue<String>(null);
        q.add("Hi");

        assertEquals(false, q.isEmpty());

    }


}
