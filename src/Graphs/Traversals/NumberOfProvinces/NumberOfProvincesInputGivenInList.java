package Graphs.Traversals.NumberOfProvinces;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces
public class NumberOfProvincesInputGivenInList {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        int n = adj.size();
        int vis[] = new int[n];
        int count = 0;

        for(int i = 0 ; i<n ; i++){
            if(vis[i]==0){
                dfs(adj , vis , i);
                count++;
            }
        }

        return count;
    }

    public static void  dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        vis[node] = 1;
        for (int j = 0; j < adj.size(); j++) {
            if (adj.get(node).get(j) == 1 && vis[j] == 0) {
                dfs(adj, vis, j); // Visit all connected cities
            }
        }
    }
}
