class DoublyLinkedList {
    static class Node {
        int val;
        Node next;
        Node prev;
        Node(int data) {
            val = data;
        }
    }
 
    private Node head;
    private int length;

    public int get(int index) {
        if(length <= index) 
            return -1;
        if(head == null)
            return -1;
        Node temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        length++;
        if(head == null) {
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(length < index) 
            return;
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        length++;
        for(int i=0; i<index-1; i++)
            temp = temp.next;
        if(head.next != null) node.next = temp.next;
        node.prev = temp;
        if(temp.next != null) temp.next.prev = node;
        temp.next = node;
    }
    
    public void deleteAtIndex(int index) {
        if(length <= index) return;
        length--;
        if(index == 0) {
            head.prev = null;
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        if(temp.next != null) temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }

    public void display() {
        if(head == null)
            return;
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();
        l.addAtIndex(0,10);
        l.addAtIndex(0,20);
        l.addAtHead(10);
        l.addAtHead(20);
        l.addAtIndex(1,30);
        l.display();
        System.out.println(l.get(0));
       
        l.display();
    }
}