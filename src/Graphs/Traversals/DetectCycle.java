package Graphs.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
     class Pair{
        int node;
        int parentNode;

        Pair(int node , int parentNode){
            this.node = node;
            this.parentNode = parentNode;
        }
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here

        int n = adj.size();
        int[] vis = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0) {
                if((bfs(adj, i , vis)))return true;
            }
        }

        return false;
    }

    // TC : O(n) + O(V + 2E);   n for outer loop and v + 2e for bfs
    private boolean bfs(ArrayList<ArrayList<Integer>> adj , int i , int vis[]){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        vis[i] = 1;

        while(!q.isEmpty()){
            Pair front = q.poll(); // make sure to store parent
            int node = front.node; // equivalent to value we get from q.poll() in bfs
            int parentNode = front.parentNode; // for checking if vis array returns true then it should not be parent node

            for(int currNode : adj.get(node)){
                if(vis[currNode] == 1 && currNode != parentNode)return true; // check for parent node
                else if(vis[currNode] == 0){
                    q.add(new Pair(currNode, node));
                    vis[currNode] = 1;
                }
            }
        }

        return false;
    }
}

class dfs_solution{
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here

        int n = adj.size();
        int[] vis = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0) {
                if((dfs(adj, i , vis , -1)))return true;
            }
        }

        return false;
    }

    // TC : O(n) + O(V + 2E);   n for outer loop and v + 2e for dfs , sc : o(n) for stack
    private boolean dfs(ArrayList<ArrayList<Integer>> adj , int node , int vis[] , int parent){
        vis[node] = 1;

        for(int currNode : adj.get(node)){
            if(vis[currNode] == 0) {
                if(dfs(adj , currNode , vis , node)) return true; // take care you should return true from here once cycle is detected
            }
            else if(vis[currNode] == 1 && currNode != parent)return true;
        }
        return false;
    }

}
