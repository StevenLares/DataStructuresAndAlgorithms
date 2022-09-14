package main.java.Interfaces;

public interface QueueImpl<E> {

    public void add(E data);

    public void remove();

    public E peek();

    public boolean isEmpty();


}
