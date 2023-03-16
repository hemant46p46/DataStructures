import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            System.out.println("Adjacency list of " + i);
            System.out.print("Head : ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    void dfs(ArrayList<ArrayList<Integer>> adj, int s, int v){
        boolean[] visited = new boolean[v];
        dfsUtil(adj, s, visited);
    }
    void dfsUtil(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s + " ");
        for (int n : adj.get(s)) {
            if (!visited[n]) {
                dfsUtil(adj, n, visited);
            }
        }
    }
    void bfs(ArrayList<ArrayList<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        LinkedList<Integer> que = new LinkedList<>();
        visited[s] = true;
        que.add(s);
        while (que.size()!=0){
            s = que.poll();
            System.out.print(s + " ");
            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    que.add(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        Graph g = new Graph();
        g.addEdge(adj, 0, 1);
        g.addEdge(adj, 1, 2);
        g.addEdge(adj, 2, 3);
        g.addEdge(adj, 3, 4);
        g.addEdge(adj, 1, 4);
        g.addEdge(adj, 0, 4);
        g.addEdge(adj, 1, 3);

        g.printGraph(adj);


        System.out.println("\n\nPrinting Dfs Traversal ........");
        int s = 3;
        g.dfs(adj, s, v);
        System.out.println("\n\nPrinting BFS Traversal ........");
        g.bfs(adj, s);
    }
}
