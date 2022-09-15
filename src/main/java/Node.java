package main.java;


//Basic data structure to hold data for SinglyLinkedList.
//Stores the link to the next Node in a reference variable
//Wrote some driver code to verify that it works
public class Node<E> {
    Node next;
    E data;

    public Node(E data){
        this.data = data;
    }

    public E getData(){
        return data;
    }

    public void setData(E data){
        this.data = data;
    }

}
