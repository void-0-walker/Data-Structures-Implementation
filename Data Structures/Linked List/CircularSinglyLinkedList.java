class CircularSinglyLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int length;

    public void insertStart(int data) {
        Node node = new Node(data);
        length++;
        if(isEmpty()) {
            head = node;
            node.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head)
            temp = temp.next;
        node.next = head;
        head = node;
        temp.next = node;
    }

    public void insertLast(int data) {
        insertAt(data, length);
    }

    public void insertAt(int data, int index) {
        if(length < index) {
            System.out.println("Index out of Bounds!");
            return;
        }
        if(index == 0) {
            insertStart(data);
            return;
        }
        Node node = new Node(data);
        length++;
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void deleteFirst() {
        if(isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        length--;
        if(head.next == head) {
            System.out.println("Deleted: "+head.data);
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != head)
            temp = temp.next;
        System.out.println("Deleted: "+head.data);
        head = head.next;
        temp.next = head;
    }

    public void deleteLast() {
        deleteAt(length-1);
    }

    public void deleteAt(int index) {
        if(length <= index) {
            System.out.println("Index out of Bounds!");
            return;
        }
        if(index == 0) {
            deleteFirst();
            return;
        }
        length--;
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        System.out.println("Deleted: "+temp.next.data);
        temp.next = temp.next.next;
    }

    public int length() {
        return length;
    }
    
    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }

    public void peek() {
        if(isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.println(head.data);
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head;
        while(temp.next != head) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}