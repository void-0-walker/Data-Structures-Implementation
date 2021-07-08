import java.util.Arrays;

class DisjointSet {
    private int[] parent;
    private int[] rank;

    DisjointSet() {
        parent = new int[10];
        rank = new int[10];
        for(int i=0; i<10; i++)
            parent[i] = i;
    }

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++)
            parent[i] = i;
        
    }
    //NAIVE IMPLEMENTATOIN:
    /*private int find(int v) {
        if(parent[v] == v)
            return v;

        return find(parent[v]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }*/

    //PATH COMPRESSION (or) COLLAPSING FIND
    /*private int find(int v) {
        if(parent[v] == v)
            return v;

        return parent[v] = find(parent[v]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }*/

    //WEIGHTED UNION or UNION RANK
    private int find(int v) {
        if(parent[v] == v)
            return v;
        return parent[v] = find(parent[v]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            if(rank[a] < rank[b])
                parent[a] = b;
            else if(rank[a] > rank[b])
                parent[b] = a;
            else {
                ++rank[a];
                parent[b] = a;
            }
        }
    }

    public void display() {
        for(int i: parent)
            System.out.print(i+"  ");
        System.out.println();
    }

    public static void main(String[] args) {
        DisjointSet d = new DisjointSet(5);
        d.union(0, 4);
        d.union(1, 2);
        d.union(2, 3);
        d.union(1, 4);
        d.union(0, 3);

        d.display();
    }
}