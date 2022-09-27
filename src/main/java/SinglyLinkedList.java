package main.java;

public class SinglyLinkedList<E> {
    private Node head;

    public SinglyLinkedList(E data){
        this.head = new Node(data);
    }

    /*
     * Expected Input: Data of type E
     * Expected Output: Appends a Node to the end (tail) of the SinglyLinkedList (ie the Nodes
     * linked together starting from the head)
     * */
    public void AppendToTail(E data){
        Node<E> end = new Node<E>(data);
        Node n = this.head;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;

    }

    /*
     * Expected Input: Data of type E
     * Expected Output: Prepends a Node to the beginning (head) of the SinglyLinkedList (ie the Nodes
     * linked together starting from the head)
     * */
    public void PrependToHead(E data){
        Node newHead = new Node(data);
        newHead.next = head;
        this.head = newHead;
    }


    /*
     * Expected Input: Positive integer (starting from 0)
     * which must be less than the length of the SinglyLinkedList
     * Expected Output: Returns data of type E at the input index
     * */
    public E get(int index){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        else {

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

    }

    /*
     * Expected Input: Positive integer (starting from 0)
     * which must be less than the length of the SinglyLinkedList
     * AND data of type E
     * Expected Output: Inserts a new node into the SinglyLinkedList between index-1
     * and index+1. It effectively shifts both sides (of index-1 and index +1) to make room
     * */
    public void add(int index, E data){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        else {

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
    }


    /*
     * Expected Input: Positive integer (starting from 0)
     * which must be less than the length of the SinglyLinkedList
     * Expected Output: Removes the node at the given index. If the node linked to another
     * node, then that node (and the nodes linked together after it) are shifted to the left
     * to make up for the gap made by node deletion.
     * */
    public void remove(int index){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        else {

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

    }


    /*
     * Expected Input: Data of type E
     * Expected Output: Initializes the head with data, if
     * it became null because of removeHead() or because it was instantiated that way.
     * */
    public void initHead(E data){
        if(this.head.data == null && data != null){
            this.head.data = data;
        }
        else throw new IndexOutOfBoundsException();
    }



    /*
     * Expected Input:
     * Expected Output: Sets head to NULL if it has no neighbors,
     * otherwise sets the neighbor to be the new head
     * */
    
    private void removeHead() {
        if (head.next != null){
            head = head.next;
        }
        else head.setData(null);
    }


    @Override
    public String toString(){

        String linkedListContents;
        Node n = this.head;


        if(n.getData() == null){
            linkedListContents = "NULL";
        }
        else {
            linkedListContents = n.getData().toString();
        }


        //iterate through all nodes after head is evaluated
        while (n.next!= null){
            if(n.next.getData() == null){
                linkedListContents = linkedListContents + ", NULL";
            }
            else {
                linkedListContents = linkedListContents + ", " + n.next.getData().toString();
            }
            n = n.next;
        }


        return "[" + linkedListContents + "]";
    }


    public int length() {

        int length = 1;
        Node n = this.head;

        while (n.next != null) {
            n = n.next;
            length++;
        }

        return length;

    }

}
