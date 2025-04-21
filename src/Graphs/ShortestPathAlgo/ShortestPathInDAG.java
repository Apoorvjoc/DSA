package Graphs.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Stack;

//tc : o(V+E)
public class ShortestPathInDAG {
    class Pair{
        int v;
        int w;

        Pair(int v , int w){
            this.v = v;
            this.w = w;
        }
    }

    private void constructGraph(int V, int E, int[][] edges , ArrayList<ArrayList<Pair>> graph){
        for(int i = 0 ; i<V ; i++){
            graph.add(new ArrayList()); // adding all vertices
        }

        for(int i = 0 ; i<E ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph.get(u).add(new Pair(v, w)); // putting in this fashion is imp
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> graph = new ArrayList();
        //construct a graph
        constructGraph(V,  E, edges , graph);

        int vis[] = new int[V];
        Stack<Integer> st = new Stack();
        //topo sort
        for(int i = 0 ; i<V ; i++){
            if(vis[i] == 0){
                topoSort(graph , i , st , vis);
            }
        }

        //putting every node of vis as +infinity
        int dist[] = new int[V];
        for(int i = 0 ; i<V ; i++){
            dist[i] = (int)1e9;
        }

        //calc distance
        int src = 0; // this can be any node for now this is given as 0
        dist[src] = 0;

        //o(v+e)
        while(!st.isEmpty()){
            int top = st.pop();

            for(int i = 0 ; i<graph.get(top).size() ; i++){
                int v = graph.get(top).get(i).v;
                int w = graph.get(top).get(i).w;

                if(dist[top] + w < dist[v]){
                    dist[v] = dist[top] + w;
                }
            }
        }

        for(int i = 0 ; i<V ; i++){
            if(dist[i] == 1e9)dist[i] = -1;
        }

        return dist;
    }

    //topo sort
    private void topoSort(ArrayList<ArrayList<Pair>> adj, int node , Stack<Integer> st , int vis[]){
        vis[node] = 1;

        for(int i = 0 ; i<adj.get(node).size() ; i++){
            int neigh = adj.get(node).get(i).v;
            if(vis[neigh] == 0){
                topoSort(adj , neigh , st , vis);
            }
        }

        st.add(node);
    }
}
