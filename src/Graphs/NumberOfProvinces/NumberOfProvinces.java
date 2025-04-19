package Graphs.NumberOfProvinces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//TC : o(n*n)
//https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n]; // Track visited cities
        int count = 0;

        for (int i = 0; i < n; i++) { // iteration for all nodes
            if (!visited[i]) { // New province found
                dfs(isConnected, visited, i);
                count++; // Increment province count
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true; // Mark current city as visited
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j); // Visit all connected cities
            }
        }
    }

    // if not getting above approach follow below or readme.md file

//    ----------------------  APPROACH - 2 ---------------------

    // o(N) + o(V + 2E)
    public int findCircleNum_aproach2(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();

        int n = isConnected.length;
        int vis[] = new int[n];
        int cnt = 0;

        //creating adj list from adj matrix

        for(int i = 0 ; i<n ; i++){ // adding arraylist to number of nodes
            adj.add(new ArrayList());
        }

        for(int row = 0 ; row < n ; row++){ // creating graph as adj list from matrix
            for(int col = 0 ; col < n ; col++){
                if(isConnected[row][col] == 1 && row != col){
                    adj.get(row).add(col);
                    adj.get(col).add(row);
                }
            }
        }

        //iterating for each node
        for(int i = 0 ; i < n ; i++){
            if(vis[i]!=1){
                cnt++;
                dfs(i , adj , vis); // use either of the one method
                bfs(i , adj , vis);
            }
        }

        return cnt;
    }

    public void dfs(int currNode , ArrayList<ArrayList<Integer>> adj , int vis[]){
        vis[currNode] = 1;
        for(int adjNode : adj.get(currNode)){
            if(vis[adjNode] == 0)
                dfs(adjNode , adj , vis);
        }
    }

    public void bfs(int node , ArrayList<ArrayList<Integer>> adj , int vis[]){
        Queue<Integer> q = new LinkedList();
        q.add(node);
        vis[node] = 1;

        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int adjNode : adj.get(currNode)){
                if(vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.add(adjNode);
                }
            }
        }
    }
}
