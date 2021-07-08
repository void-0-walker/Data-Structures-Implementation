class CircularDoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int length;

    public void insertAtStart(int data) {
        Node node = new Node(data);
        length++;
        if(isEmpty()) {  
            head = node;
            node.next = node;
            node.prev = node; 
        }
        Node temp = head.prev;
        temp.next = node;
        node.prev = temp;
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void insertAtLast(int data) {
        Node node = new Node(data);
        length++;
        if(isEmpty()) {  
            head = node;
            node.next = node;
            node.prev = node; 
        }
        Node temp = head.prev;
        temp.next = node;
        node.prev = temp;
        node.next = head;
        head.prev = node;
    }

    public void insertAtIndex(int data, int index) {
        if(length < index) {
            System.out.println("Index out of Bounds!");
            return;
        }
        if(index == 0){
            insertAtStart(data);
            return;
        }
        if(index == length) {
            insertAtLast(data);
            return;
        }
        Node node = new Node(data);
        length++;

        Node temp = head;
        
        for(int i=0; i<index-1; i++)
            temp = temp.next;
        
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
    }

    public void deleteAtStart() {
        if(isEmpty()) {
            System.out.println("List Empty!"); 
            return;
        }
        length--;
        if(head.next == head) {
            head = null;
            return;
        }
        Node temp = head.prev;
        temp.next = head.next;
        head = head.next;
        head.prev = temp;
    }
    
    public void deleteAtLast() {
        if(isEmpty()) {
            System.out.println("List Empty!"); 
            return;
        }
        length--;
        if(head.next == head) {
            head = null;
            return;
        }
        Node temp = head.prev;
        temp.prev.next = head;
        head.prev = temp.prev;
    }

    public void deleteAtIndex(int index) {
        if(length <= index) {
            System.out.println("Index out of Bounds!");
            return;
        }
        if(index == 0){
            deleteAtStart();
            return;
        }
        if(index == length) {
            deleteAtLast();
            return;
        }
        length--;
        Node temp = head;

        for(int i=0; i<index-1; i++)
            temp = temp.next;

        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List Empty!"); 
            return;
        }
        Node temp = head;
        while(temp.next != head) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data+" ");
    }

    public void displayReverse() {
        if(isEmpty()) {
            System.out.println("List Empty!"); 
            return;
        }
        Node temp = head.prev;
        Node temp2 = temp.prev;
        System.out.print(temp.data+" ");
        while(temp2 != temp) {
            System.out.print(temp2.data+" ");
            temp2 = temp2.prev;
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList l = new CircularDoublyLinkedList();
        l.insertAtLast(1);
        l.insertAtLast(2);
        l.insertAtLast(3);
        l.insertAtLast(4);
        l.insertAtLast(5);
        l.insertAtLast(6);
        l.insertAtLast(7);
        l.deleteAtIndex(3);
      
       
        System.out.println(l.length());
        l.display();
        l.displayReverse();
    }
}