class StackUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private Node head;

    public void push(int data) {
        Node node = new Node(data);
        if(isEmpty()) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack Empty!");
            return;
        }
        System.out.println("Deleted: "+head.data);
        head = head.next;
    }

    public void peek() {
        if(isEmpty()) {
            System.out.println("Stack Empty!");
            return;
        }
        System.out.println(head.data);
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack Empty!");
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }
}