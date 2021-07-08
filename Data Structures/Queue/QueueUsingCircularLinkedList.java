class QueueUsingCircularLinkedList {
    
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public void enQueue(int data) {
        Node node = new Node(data);
        if(isEmpty()){
            front = node;
            rear = node;
            node.next = front;
            return;
        }
        rear.next = node;
        node.next = front;
        rear = node;
    }

    public void deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        if(front == rear) {
            System.out.println("Deleted: "+front.data);
            front = null;
            rear = null;
            return;
        }
        System.out.println("Deleted: "+front.data);
        front = front.next;
        rear.next = front;
    }

    public boolean isEmpty() {
        if(front == null)
            return true;
        return false;
    }

    public void peek() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println(front.data);
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        Node temp = front;
        while(temp.next != front) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}