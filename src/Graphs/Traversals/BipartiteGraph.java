package Graphs.Traversals;

import java.util.LinkedList;
import java.util.Queue;

//TC : same as bfs o(V+2E)
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        for(int i = 0 ; i<n ; i++){
            if(color[i] == 0){
                if(!bfs(i, color, graph)){
                    return false;
                }
            }
        }

        return true;

    }

    private boolean bfs(int node , int color[] , int graph[][]){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1; // taking color as 1 and -1 , by default value of int arr is 0.

        while(!q.isEmpty()){
            int currNode = q.poll();

            for(int neigh : graph[currNode]){
                // System.out.print(neigh+" ");
                if(color[neigh] == color[currNode])return false;
                else if(color[neigh] == 0){
                    q.add(neigh);
                    color[neigh] = -1 * color[currNode];
                }
            }
        }

        return true;
    }

    private boolean dfs(int node , int colors[] , int graph[][] , int currColor){
        colors[node] = currColor;

        for(int neigh : graph[node]){
            if(colors[neigh] == currColor)return false;
            else if(colors[neigh] == 0){
                if(!dfs(neigh, colors, graph, -1 * currColor))return false;
            }
        }
        return true;
    }
}
