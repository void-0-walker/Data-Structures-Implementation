import java.util.ArrayDeque;

class AdjacencyMatrix {
    private int[][] mat;
    private int V;

    AdjacencyMatrix(int V) {
        this.V = V;
        mat = new int[V][];
        for(int i=0; i<V; i++)
            mat[i] = new int[V];
    }

    public void addEdgeUndirected(int u, int v)  {
        mat[u][v] = 1;
        mat[v][u] = 1;
    }

    public void addEdgeDirected(int u, int v)  {
        mat[u][v] = 1;
    }

    public void BSFTraversal(int s) {
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> queue = new ArrayDeque<>(V);
        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s+" ");
            for(int i=0; i<V; i++) {
                if(mat[s][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    //Works for diconnected graphs as well
    public void BFSTraversalSafe() {
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> queue = new ArrayDeque<>(V);
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                visited[i] = true;
                queue.add(i);
                while(!queue.isEmpty()) {
                    int s = queue.poll();
                    System.out.print(s+" ");
                    for(int j=0; j<V; j++) {
                        if(mat[s][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }        
    }

    public void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s+" ");

        for(int i=0; i<V; i++)
            if(mat[s][i] == 1 && !visited[i])
                DFSUtil(i, visited);
            
    }

    public void DFSTraversal(int s) {
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    //Works for diconnected graphs as well
    public void DFSTraversalSafe() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }

    public void display() {
        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(7);
        g.addEdgeDirected(0, 1);
        g.addEdgeDirected(0, 2);
        g.addEdgeDirected(1, 2);
        g.addEdgeDirected(2, 0);
        g.addEdgeDirected(2, 3);
        g.addEdgeDirected(3, 3);
        g.addEdgeDirected(4, 5);
        g.addEdgeDirected(4, 6);
        g.display();
        g.DFSTraversalSafe();
    }
}
