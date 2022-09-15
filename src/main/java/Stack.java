package main.java;/*
* This implementation depends on the main.java.SinglyLinkedList class
* */

import main.java.Interfaces.StackImpl;

public class Stack<E> implements StackImpl<E> {

    private SinglyLinkedList sLinkedList;

    public Stack(E data){
        sLinkedList = new SinglyLinkedList(data);
    }

    /*
     * Expected Input:
     * Expected Output: Returns data of type E stored at the top of the Stack
     * AND also removes this node. (See LIFO)
     *
     * NOTE: This is implemented correctly, since each node being pushed
     * using push(E data) is prepended to the head.
     * */
    @Override
    public E pop() {
        E data = (E) sLinkedList.get(0);
        sLinkedList.removeHead();
        return data;
    }

    /*
     * Expected Input:
     * Expected Output: Returns data of type E stored at the top of the Stack.
     * Unlike pop(), it does not remove it
     * */
    @Override
    public E peek() {
        E data = (E) sLinkedList.get(0);
        return data;
    }

    /*
     * Expected Input: Data of type E
     * Expected Output: Prepends this data type E to the head node.
     * Since pop() and peek() only look at the head, the LIFO property is still followed

     * */
    @Override
    public void push(E data) {
        sLinkedList.PrependToHead(data);
    }


    /*
     * Expected Input:
     * Expected Output: returns true if empty, false otherwise
     * */
    @Override
    public boolean isEmpty() {
        return sLinkedList.get(0) == null;
    }
}
