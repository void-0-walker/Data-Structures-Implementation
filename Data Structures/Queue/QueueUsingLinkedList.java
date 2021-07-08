class QueueUsingLinkedList {
    
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
            return;
        }
        rear.next = node;
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
        while(temp.next != null) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}