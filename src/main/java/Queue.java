package main.java;/*
 * This implementation depends on the main.java.SinglyLinkedList class
 * */

import main.java.Interfaces.QueueImpl;

public class Queue<E> implements QueueImpl<E> {
    private SinglyLinkedList sLinkedList;

    public Queue(E data){
        sLinkedList = new SinglyLinkedList(data);
    }

    /*
     * Expected Input: Data of Type E
     * Expected Output: Appends data of type E to the end of the queue
     * */
    @Override
    public void add(E data) {
        sLinkedList.AppendToTail(data);

    }

    /*
     * Expected Input:
     * Expected Output: Removes data of type E from the beginning of the queue. Ensures FIFO
     * */
    @Override
    public void remove() {
        sLinkedList.remove(0);

    }

    /*
     * Expected Input:
     * Expected Output: Returns data of type E that would be removed if you ran remove().
     * Does not remove it from the queue.
     * */
    @Override
    public E peek() {
        return (E) sLinkedList.get(0);

    }

    /*
     * Expected Input:
     * Expected Output: returns true if empty, false otherwise
     * */
    @Override
    public boolean isEmpty() {
        return sLinkedList.get(0) == null && sLinkedList.length() == 1;
    }


    @Override
    public String toString(){
        return sLinkedList.toString();
    }
}
