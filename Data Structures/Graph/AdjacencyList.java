import java.util.ArrayDeque;
import java.util.LinkedList;

class AdjacencyList {
    private int v;
    private LinkedList<Integer>[] adj;
    int[] disjointSet;
    int[] rank;

    AdjacencyList() {
        this.v = 10;
        adj = new LinkedList[10];
        for(int i=0; i<10; i++)
            adj[i] = new LinkedList<>();

        rank = new int[10];
        disjointSet = new int[10];
        for(int i=0; i<10; i++)
            disjointSet[i] = i;
    }

    AdjacencyList(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
            adj[i] = new LinkedList<Integer>();
            
        rank = new int[v];
        disjointSet = new int[v];
        for(int i=0; i<v; i++)
            disjointSet[i] = i;
        
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void display() { 
        for(int i=0; i<v; i++) {
            System.out.print("Head "+i+"->");
            for(int j: adj[i])
                System.out.print(j+"->");
            System.out.println("null");
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[this.v];
        DFSHelper(v, visited);
    }

    //Works for DISCONNECTED COMPONENTS as well
    public void DFSSafe() {
        boolean[] visited = new boolean[this.v];
        for(int i=0; i<this.v; i++)
            if(!visited[i])
                DFSHelper(i, visited);
    }

    private void DFSHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+"    ");
        for(int i: adj[v])
            if(!visited[i])
                DFSHelper(i, visited);
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[this.v];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[v] = true;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u+"    ");

            for(int i: adj[u]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    //Works for DISCONNECTED COMPONENTS as well
    public void BFSSafe() {
        boolean[] visited = new boolean[this.v];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<this.v; i++) {
            if(!visited[i]) {
                visited[i] = true;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int u = queue.poll();
                    System.out.print(u+"    ");

                    for(int j: adj[u]) {
                        if(!visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }

    public boolean isCyclicDirected() {
        boolean[] visited = new boolean[this.v];
        boolean[] stack = new boolean[this.v];

        for(int i=0; i<this.v; i++)
            if(isCyclicDirectedHelper(i, visited, stack))
                return true;
            
        return false;
    }

    private boolean isCyclicDirectedHelper(int v, boolean[] visited, boolean[] stack) {
        if(stack[v])
            return true;
        if(visited[v])
            return false;

        stack[v] = true;
        visited[v] = true;

        for(int i: adj[v])
            if(isCyclicDirectedHelper(i, visited, stack))
                return true;

        stack[v] = false;
        return false;
    }

    //USING DFS
    /*public boolean isCyclicUndirected() {
        boolean[] visited = new boolean[this.v];

        for(int i=0; i<this.v; i++)
            if(!visited[i])
                if(isCyclicUndirectedHelper(i, visited, -1))
                    return true;
        
        return false;
    }

    public boolean isCyclicUndirectedHelper(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for(int i:adj[v]) {
            if(!visited[i]) {
                if(isCyclicUndirectedHelper(i, visited, v))
                    return true;
            } else if(i != parent) {
                return true;
            }
        }
        return false;
    }*/


    //USING DISJOINT SETS
    private int find(int v) {
        if(disjointSet[v] == v)
            return v;

        return disjointSet[v] = find(disjointSet[v]);
    }

    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(rank[a] < rank[b])
                disjointSet[a] = b;
            else if(rank[a] > rank[b])
                disjointSet[b] = a;
            else {
                ++rank[a];
                disjointSet[b] = a;
            }
            return false;
        }
        return true;
    }

    public boolean isCyclicUndirected() {
        boolean[] visited = new boolean[this.v];

        for(int i=0; i<v; i++)
            if(isCyclicUndirectedHelper(i, visited))
                return true;

        return false;
    }

    private boolean isCyclicUndirectedHelper(int v, boolean[] visited) {
        visited[v] = true;

        for(int i: adj[v])
            if(!visited[i])
                if(union(v, i))
                    return true;
        
        return false;
    }
   
    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(2, 6);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.display();

        System.out.println(g.isCyclicUndirected());
    }
}