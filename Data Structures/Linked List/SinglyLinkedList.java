class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int length;
    
    public void insertFirst(int data) {
        Node node = new Node(data);
        length++;
        if(isEmpty()) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void insertLast(int data) {
        insertAt(data, length);
    }

    public void insertAt(int data, int index) {
        if(length < index || index < 0) {
            System.out.println("Index out of Bound!");
            return;
        }
        Node node = new Node(data);
        length++;
        if(index == 0) {
            node.next = head;
            head = node;
            return;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++) 
            temp = temp.next;
        
        node.next = temp.next;
        temp.next = node;
    }

    public void deleteFirst() {
        if(isEmpty()) {
            System.out.println("List Empty!");
            return;
        }
        length--;
        System.out.println("Deleted: "+head.data);
        head = head.next;
    }

    public void deleteLast() {
        deleteAt(length-1);
    }

    public void deleteAt(int index) {
        if(length <= index || index < 0) {
            System.out.println("Index out of Bound!");
            return;
        }
        length--;
        if(index == 0) {
            System.out.println("Deleted: "+head.data);
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        System.out.println("Deleted: "+temp.next.data);
        temp.next = temp.next.next;
    }

    public void reverse() {
        if(isEmpty()) {
            System.out.println("List Empty!");
            return;
        }
        Node temp = head;
        Node aTemp = temp.next;
        Node pTemp = temp;
        pTemp.next = null;
        while(aTemp != null) {
            temp = aTemp;
            aTemp = aTemp.next;
            temp.next = pTemp;
            pTemp = temp;
        }
        head = temp;
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
            System.out.println("List Empty!");
            return;
        }
        System.out.println(head.data);
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List Empty!");
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}