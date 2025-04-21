package Graphs.CycleDetect;

import java.util.ArrayList;

//O (V+E)
public class DetectCycleCyclicGraph {
    // Function to detect cycle in directed graph
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        int[] vis = new int[n + 1]; // visited nodes (1-indexed)
        int[] pathVis = new int[n + 1]; // nodes in current path (1-indexed)

        // Start DFS for every unvisited node
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (dfs(i, edges, vis, pathVis)) {
                    return true; // cycle detected
                }
            }
        }

        return false; // no cycle detected
    }

    // DFS helper function to detect cycle
    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> edges, int[] vis, int[] pathVis) {
        vis[node] = 1; // mark the node as visited
        pathVis[node] = 1; // mark the node as part of the current DFS path

        // Visit all the neighbors of the node
        for (int neigh : edges.get(node)) {
            if (pathVis[neigh] == 1) {
                return true; // found a cycle
            } else if (vis[neigh] == 0) {
                if (dfs(neigh, edges, vis, pathVis)) {
                    return true; // cycle detected in DFS
                }
            }
        }

        pathVis[node] = 0; // unmark the node when we backtrack
        return false; // no cycle detected from this node
    }
}
