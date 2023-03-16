import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
    int v;
    public ArrayList<Integer>[] adjList;
    public Graph1(int v){
        this.v = v;
        adjList = new ArrayList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new ArrayList<>();
        }
    }
    private void addEdge(int s, int d){
        adjList[s].add(d);
        adjList[d].add(s);
    }
    private void printGraph(){
        for(int i=0;i<adjList.length;i++){
            System.out.println("Adjacency List of " + i);
            System.out.print("Head : ");
            for(int j=0;j<adjList[i].size();j++){
                System.out.print("-> " + adjList[i].get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph1 g = new Graph1(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }

    public static ArrayList<Integer> bfsOfGraph
            (int V, ArrayList<Boolean>[] adj) {
        ArrayList<Boolean> vis = new ArrayList<>(V);
        ArrayList<Integer> bfs_traversal = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            // To check if already visited
            if (!vis.get(i)) {
                Queue<Integer> q = new LinkedList<>();
                vis.set(i, true);
                q.add(i);

                // BFS starting from ith node
                while (!q.isEmpty()) {
                    int g_node = q.peek();
                    q.poll();
                    bfs_traversal.add(g_node);
                    for (int it = 0;
                         it < adj[g_node].toArray().length;
                         it++) {
                        if (adj[g_node].get(it)) {
                            if (!vis.get(it)) {
                                vis.set(it, true);
                                q.add(it);
                            }
                        }
                    }
                }
            }
        }
        return bfs_traversal;
    }

    private static void bfsOfAdjMatrix(int start, int[][] adj){
        int v = adj.length;

        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        ArrayList<Integer> q = new ArrayList<>();

        visited[start] = true;
        q.add(start);
        int vis;
        while(!q.isEmpty()){
            vis = q.get(0);
            System.out.println(vis + " ");
            q.remove(q.get(0));

            for(int i=0;i<v;i++){
                if(adj[vis][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
