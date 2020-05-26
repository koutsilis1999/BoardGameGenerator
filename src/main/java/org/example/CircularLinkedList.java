package org.example;

public class CircularLinkedList<T> {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public CircularLinkedList() {
    }

    public void addNodeAtStart(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            newNode.next = temp;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(T data) {
        if (size == 0) {
            addNodeAtStart(data);
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            size++;
        }
    }

    /*public void deleteNodeFromStart(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else{
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            tail.next=head;
            size--;
        }
      }*/

    public T elementAt(int index) {
        Node n = head;
        while (index != 0) {
            n = n.next;
            index--;
        }
        return (T) n.data;
    }


    public int getSize() {
        return size;
    }

    public Node getNextNode(Node node) {
        return node.next;
    }

}


