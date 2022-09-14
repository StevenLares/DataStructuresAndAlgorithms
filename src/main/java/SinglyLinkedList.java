package main.java;

public class SinglyLinkedList<E> {
    Node head;

    public SinglyLinkedList(E data){
        this.head = new Node(data);
    }

    public void AppendToTail(E data){
        Node<E> end = new Node<>(data);
        Node n = this.head;
        while (n.next!= null){
            n = n.next;
        }
        n.next = end;
    }

    public void PrependToHead(E data){
        Node newHead = new Node(data);
        newHead.next = head;
        this.head = newHead;
    }



    public E get(int index){
        int i = 0;
        Node n = this.head;

        if(index == 0){
            return (E) n.getData();
        }
        else {
            while (n.next != null && i != index) {
                n = n.next;
                i++;
            }
            if (i == index) {
                return (E) n.getData();
            } else throw new IndexOutOfBoundsException();

        }

    }


    public void add(int index, E data){
        int i = 0;
        Node n = this.head;
        if(index == 0){
            PrependToHead(data);
        }
        else {
            while (n.next != null && i != index - 1) {
                n = n.next;
                i++;
            }

            if (i == index - 1) {
                Node insert = new Node(data);
                Node left = n;
                Node right = n.next;
                left.next = insert;
                insert.next = right;
            } else throw new IndexOutOfBoundsException();
        }
    }

    public void remove(int index){
        int i = 0;
        Node n = this.head;
        if(index == 0){
            removeHead();
        }
        else {

            while (n.next.next != null && i != index - 1) {
                n = n.next;
                i++;
            }
            if (i == index - 1) {
                Node toRemove = n.next;
                Node adjNode = toRemove.next;
                n.next = adjNode;
                toRemove.next = null;
            } else throw new IndexOutOfBoundsException();

        }

    }

    public void initHead(E data){
        if(this.head.data == null){
            this.head.data = data;
        }
        else throw new IndexOutOfBoundsException(); //TODO: Create new exception type, for head already initialized
    }


    //TODO: remove instances of this
    public void removeHead() {
        if (head.next != null){
            head = head.next;
        }
        else head.setData(null);
    }
}
