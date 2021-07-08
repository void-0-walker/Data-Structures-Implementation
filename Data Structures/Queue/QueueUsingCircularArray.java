class QueueUsingCircularArray {
    
    private int[] arr;
    private int front = -1;
    private int rear = -1;

    QueueUsingCircularArray() {
        arr = new int[10]
    }

    QueueUsingCircularArray(int size) {
        arr = new int[size];
    }

    public void enQueue(int data) {
        if(isEmpty()) {
            front++;
            rear++;
        }
        else if((rear+1)%arr.length == front)
        {
            System.out.println("Queue is Full!");
            return;
        }
        else rear = (rear+1)%arr.length;
        
        arr[rear] = data;
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
        System.out.println("Deleted: "+arr[front]);
        front = (front+1)%arr.length;
    }

    public boolean isEmpty() {
        if(front == -1)
            return true;
        return false;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return 0;
        }
        return arr[front];
    }
    
    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        for(int i=front; i<rear; i=(i+1)%arr.length)
            System.out.print(arr[i]+" ");
        System.out.println(arr[rear]);
    }    
}