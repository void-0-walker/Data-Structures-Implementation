class MinHeap {

    private int[] heap;
    private int size;

    MinHeap() {
        heap = new int[11];
        size = 1;
    }

    MinHeap(int maxSize) {
        heap = new int[maxSize+1];
        size = 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int val) {
        if(size < heap.length) {
            heap[size] = val;
            int curr = size++;
            int parent = curr/2;

            while(parent>0) {
                if(heap[curr] < heap[parent])
                    swap(curr, parent);
                curr = parent;
                parent = curr/2;
            }
        } else {
            System.out.println("Heap is full");
        }
    }

    private void heapify(int i) {
        int smallest = i;
        int l = 2*i;
        int r = 2*i+1;

        if(l < size && heap[l] < heap[smallest])
            smallest = l;
        if(r < size && heap[r] < heap[smallest])
                smallest = r;
        
        if(smallest != i) {
            swap(smallest, i);
            heapify(smallest);
        }
    }

    public void delete() {
        if(size == 1) {
            System.out.println("Heap Empty");
        } else {
            System.out.println("Deleted: "+heap[1]);
            heap[1] = heap[--size];
            heapify(1);
        }
    }

    public void display() {
        for(int i=1; i<size; i++)
            System.out.print(heap[i]+" ");
        System.out.println();
    }
}