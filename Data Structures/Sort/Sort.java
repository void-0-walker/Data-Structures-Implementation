import java.util.*;

class Sort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int max(int[] a, int n) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(max < a[i])
                max = a[i];
        }
        return max;
    }

    public static void BubbleSort(int[] a, int n) {
        for(int i=0; i<n-1; i++) {
            boolean swap = false;
            for(int j=0; j<n-i-1; j++)
                if(a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    swap = true;
                }
            if(!swap)
                break;
        }
    }

    public static void InsertionSort(int[] a, int n) {
        for(int i=1; i<n; ++i) {
            int temp = a[i];
            int j=i-1;
            while(j>=0 && a[j] > temp) {
                    a[j+1] = a[j];
                    j--;
            }
            a[j+1] = temp;
        }
    }

    public static void BinaryInsertionSort(int[] a, int n) {
        for(int i=1; i<n; ++i) {
            int temp = a[i];
            int j = Math.abs(Arrays.binarySearch(a, 0, i, temp) + 1);
            System.arraycopy(a, j, a, j + 1, i - j);
            a[j] = temp;
        }
    }

    public static void SelectionSort(int[] a, int n) {
        for(int i=0; i<n-1; i++) {
            int min = i;
            for(int j=i+1; j<n; j++)
                if(a[j] < a[min])
                    min = j;
            if(min != i) {
                swap(a, i, min);
            }
        }
    }

    private static void BucketSortIteration(int[] a, int n, int exp) {
        Vector<Integer>[] bucket = new Vector[n];
        for(int i=0; i<n; i++)
            bucket[i] = new Vector<>();
        for(int i: a)
            bucket[(i/exp)%10].add(i);
        
        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < bucket[i].size(); j++)
                a[index++] = bucket[i].get(j);
    }

    public static void BucketSort(int[] a, int n) {
        int max = max(a, n);
        for(int exp=1; max/exp>0; exp *= 10)
            BucketSortIteration(a, n, exp);
    }

    public static void CountingSort(int[] a, int n) {
        int max = max(a, n);
        int[] count = new int[max+1];
        for(int i: a)
            ++count[i];
        for(int i=1; i<count.length; i++)
            count[i] += count[i-1];

        int[] b = new int[n];
        for(int i=n-1; i>=0; i--)
            b[--count[a[i]]] = a[i];
        for(int i=0; i<n; i++)
            a[i] = b[i];
    }

    private static void RadixCountingSort(int[] a, int n, int exp) {
        int[] count = new int[10];
        
        for (int i=0; i<n; i++)
            ++count[(a[i]/exp) % 10];
        for(int i=1; i<10; i++)
            count[i] += count[i-1];

        int[] b = new int[n];
        for(int i=n-1; i>=0; i--)
            b[--count[(a[i]/exp) % 10]] = a[i];
        for(int i=0; i<n; i++)
            a[i] = b[i];
    }
    
    public static void RadixSort(int[] a, int n) {
        int max = max(a, n);

        for(int exp=1; max/exp>0; exp *= 10)
            RadixCountingSort(a, n, exp);
    }

    public static void ShellSort(int[] a, int n) {
        for(int gap=n/2; gap>0; gap /= 2)
            for(int i=gap; i<n; i++)
                for(int j=i-gap; j>=0; j -= gap) {
                    if(a[j+gap] < a[j]) 
                        swap(a, j, j+gap);
                    else 
                        break;
                }
    }

    private static void merge(int[] a, int l, int mid, int h) {
        int n1 = mid - l + 1;
        int n2 = h - mid;
 
        int[] L = new int[n1];
        int[] R = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[mid + 1 + j];
 
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }

        while (i < n1)
            a[k++] = L[i++];

        while (j < n2)
            a[k++] = R[j++];
    }

    public static void MergeSort(int[] a, int l, int h) {
        if(l<h) {
            int mid = (l+h)/2;
            MergeSort(a, l, mid);
            MergeSort(a, mid+1, h);
            merge(a, l, mid, h);
        }
    }

    private static int partition(int[] a, int l, int h) {
        int i = l;
        int j = h;
        int pivot = a[l];
        while(i<j) {
            do {
                i++;
            }while(i<=h && a[i] <= pivot);
            
            while(j>=l && a[j] > pivot)
                j--;

            if(i < j) 
                swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    public static void QuickSort(int[] a, int l, int h) {
        if(l<h) {
            int p = partition(a, l, h);
            QuickSort(a, p+1, h);
            QuickSort(a, l, p-1);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        if (l < n && a[l] > a[largest])
            largest = l;
 
        if (r < n && a[r] > a[largest])
            largest = r;
 
        if (largest != i) {
            swap(a, i, largest);
            heapify(a, n, largest);
        }
    }

    public static void HeapSort(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);
 
        for (int i = n - 1; i > 0; i--) {
            swap(a, i, 0);
            heapify(a, i, 0);
        }
    }

    public static void display(int[] a) {
        for(int i: a)
            System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        Sort.QuickSort(a, 0, a.length-1);
        Sort.display(a);
    }
}