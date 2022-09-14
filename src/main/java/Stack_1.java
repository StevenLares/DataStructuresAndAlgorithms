package main.java;/*
* This implementation depends on the main.java.SinglyLinkedList class
* */

import main.java.Interfaces.StackImpl;

public class Stack_1<E> implements StackImpl<E> {

    private SinglyLinkedList sLinkedList;

    public Stack_1(E data){
        sLinkedList = new SinglyLinkedList(data);
    }

    @Override
    public E pop() {
        E data = (E) sLinkedList.get(0);
        sLinkedList.removeHead();
        return data;
    }

    @Override
    public E peek() {
        E data = (E) sLinkedList.get(0);
        return data;
    }

    @Override
    public void push(E data) {
        sLinkedList.PrependToHead(data);
    }

    @Override
    public boolean isEmpty() {
        return sLinkedList.get(0) == null;
    }
}
