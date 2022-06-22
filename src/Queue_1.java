/*
 * This implementation depends on the SinglyLinkedList class
 * */

import Interfaces.QueueImpl;

public class Queue_1<E> implements QueueImpl<E> {
    private SinglyLinkedList sLinkedList;

    public Queue_1(E data){
        sLinkedList = new SinglyLinkedList(data);
    }

    @Override
    public void add(E data) {
        sLinkedList.AppendToTail(data);

    }

    @Override
    public void remove() {
        sLinkedList.removeHead();

    }

    @Override
    public E peek() {
        return (E) sLinkedList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return sLinkedList.get(0) == null;
    }
}
