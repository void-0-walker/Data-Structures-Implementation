class QueueUsingArray {
    private int arr[];
    private int front = -1;
    private int rear = -1;

    QueueUsingArray() {
        arr = new int[10];
    }
    QueueUsingArray(int size) {
        arr = new int[size];
    }

    public void enQueue(int element) {
        if(isEmpty()) {
            front++;
            arr[++rear] = element;
            return;
        }
        if(rear+1 == arr.length) {
            System.out.println("Queue is full!");
            return;
        }
        arr[++rear] = element;

    }

    public void deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        if(front == rear) {
            System.out.println("Deleted: "+arr[front]);
            front = -1;
            rear = -1;
            return;
        }
        System.out.println("Deleted: "+arr[front++]);
    }

    public boolean isEmpty() {
        if(front == -1) 
            return true;
        return false;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        for(int i=front; i<rear; i++)
            System.out.print(arr[i]+" ");
        System.out.println(arr[rear]);
    }
}