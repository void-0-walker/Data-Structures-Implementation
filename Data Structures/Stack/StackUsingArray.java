class StackUsingArray {
    private int a[];
    private int top = -1;
    StackUsingArray() {
        a = new int[10];
    }
    StackUsingArray(int size) {
        a = new int[size];
    }

    public void push(int element) {
        if(top+1 == a.length) {
            System.out.println("Stack Overflow!");
            return;
        }
        a[++top] = element;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow!");
            return;
        }
        System.out.println("Deleted: "+a[top--]);
    }

    public void peek() {
        if(isEmpty()) {
            System.out.println("Stack Empty!");
            return;
        }
        System.out.println(a[top]);
    }

    public boolean isEmpty() {
        if(top == -1) 
            return true;
        return false;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack Empty!");
            return;
        }
        for(int i=0; i<=top; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}