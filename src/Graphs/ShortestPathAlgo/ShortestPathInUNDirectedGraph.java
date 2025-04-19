package Graphs.ShortestPathAlgo;

import java.util.*;

public class ShortestPathInUNDirectedGraph {
    class Pair{
        int node;
        int dist;

        Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int V = adj.size();
        int dist[] = new int[V];
        int vis[] = new int[V];

        Arrays.fill(dist, (int) 1e9);

        Queue<Pair> q = new LinkedList();
        q.add(new Pair(src , 0));  // as src = 0 and distance to reach to 0 from 0 will be 0
        dist[src] = 0;

        //Applying bfs as all weights as are equal i.e 1
        while(!q.isEmpty()){
            Pair front = q.poll();
            int node = front.node;
            int disti = front.dist;

            for(int neigh : adj.get(node)){
                if(vis[neigh] == 0){
                    q.add(new Pair(neigh , disti+1));
                    dist[neigh] = Math.min(disti+1 , dist[neigh]);
                    vis[neigh] = 1;
                }
            }
        }


        for(int i = 0 ; i<V ; i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }

        return dist;
    }

    private void topoSort(ArrayList<ArrayList<Integer>> adj, int node , Stack<Integer> st , int vis[]){
        vis[node] = 1;

        for(int neigh : adj.get(node)){
            if(vis[neigh] == 0){
                topoSort(adj , neigh , st , vis);
            }
        }

        st.add(node);
    }
}
