package test.main.java;

import main.java.Queue;
import main.java.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pop() {
        Stack<Integer> s = new Stack<Integer>(3);
        s.push(83);
        s.push(32);
        s.pop();

        assertEquals("[83, 3]", s.toString());

    }

    @Test
    void pop_oneValue() {
        Stack<Integer> s = new Stack<Integer>(3);
        s.pop();

        assertEquals("[NULL]", s.toString());

    }

    @Test
    void peek() {
        Stack<Integer> s = new Stack<Integer>(3);
        s.push(83);
        s.push(32);

        assertEquals(32, s.peek());
    }

    @Test
    void push() {
        Stack<Integer> s = new Stack<Integer>(3);
        s.push(83);
        s.push(32);

        assertEquals("[32, 83, 3]", s.toString());
    }

    @Test
    void isEmpty() {
        Stack<Integer> s = new Stack<Integer>(null);

        assertEquals(true, s.isEmpty());

    }


    @Test
    void isEmpty_OnlyHeadNull() {
        Stack<String> s = new Stack<String>(null);
        s.push("Hi");

        assertEquals(false, s.isEmpty());

    }
}