class MaxHeap {
    private int[] heap;
    private int size;

    MaxHeap() {
        heap = new int[10];
    }

    MaxHeap(int n) {
        heap = new int[n];
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int ele) {
        if(size == heap.length) {
            System.out.println("Heap Full!");
            return;
        }
        int pos = size++;
        int parent = (pos-1)/2;
        heap[pos] = ele;

        while(parent >= 0 && heap[parent] < heap[pos]) {
            swap(parent, pos);
            pos = parent;
            parent = (pos-1)/2;
        }
    }

    private void heapify(int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < size && heap[l] > heap[largest])
            largest = l;
        if(r < size && heap[r] > heap[largest])
            largest = r;

        if(largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public int delete() {
        if(size == 0)
            return -1;
        int del = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return del;
    }

    public void display() {
        for(int i = 0; i < size; i++)
            System.out.print(heap[i]+"    ");
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(6);
        h.insert(7);
        h.insert(8);
        h.insert(9);
        h.insert(10);
        h.insert(11);
        h.delete();
        h.delete();
        h.delete();
        h.delete();
        h.delete();
        h.delete();
        h.delete();
        h.delete();
        h.delete();
        h.delete();

        h.display();
    }
}