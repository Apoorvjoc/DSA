package Graphs.CycleDetect;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/description/
public class SafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList();
        int n = graph.length;
        int vis[] = new int[n];
        int pathVis[] = new int[n];

        for(int i = 0 ; i<n ; i++){
            if(vis[i] == 0){
                dfs_detectCycleInCyclicGraph(graph , vis , pathVis , i , ans); // we need to check for all unvisited nodes , do not return if cycle found
            }
        }

        for(int i = 0 ; i<n ; i++){
            if(pathVis[i] == 0)ans.add(i);
        }

        return ans;
    }

    private boolean dfs_detectCycleInCyclicGraph(int[][] graph , int vis[] , int pathVis[] , int node , List<Integer> ans){
        vis[node] = 1;
        pathVis[node] = 1;

        for(int neigh : graph[node]){
            if(vis[neigh] == 1 && pathVis[neigh] == 1)return true;
            else if(vis[neigh] == 0){
                if(dfs_detectCycleInCyclicGraph(graph , vis , pathVis , neigh , ans)) return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
}
