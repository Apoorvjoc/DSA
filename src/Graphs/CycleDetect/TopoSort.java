package Graphs.CycleDetect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort {
    public int[] topoSort(int V, List<Integer>[] edges) {
        // code here
        Queue<Integer> q = new LinkedList();
        int indegree[] = new int[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // calculating indegree
        for(int i = 0 ; i<V ; i++){
            for(int node : edges[i]){
                indegree[node]++;
            }
        }

        // put all nodes whose indegree is 0 in queue
        for(int i = 0 ; i<V ; i++){
            if(indegree[i] == 0){
                q.add(i);
                ans.add(i);
            }
        }

        //perform normal bfs
        while(!q.isEmpty()){
            int front = q.poll();

            for(int neigh : edges[front]){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                    ans.add(neigh);
                }
            }
        }

        int ansArr[] = new int[ans.size()];
        int k = 0;
        for(int ele : ans){
            ansArr[k++] = ele;
        }

        return ansArr;
    }

    public int[] topoSort_DFS(int V, List<Integer>[] edges) {
        // code here
        Queue<Integer> q = new LinkedList();
        int indegree[] = new int[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // calculating indegree
        for(int i = 0 ; i<V ; i++){
            for(int node : edges[i]){
                indegree[node]++;
            }
        }

        // put all nodes whose indegree is 0 in queue
        for(int i = 0 ; i<V ; i++){
            if(indegree[i] == 0){
                q.add(i);
                ans.add(i);
            }
        }

        //perform normal bfs
        while(!q.isEmpty()){
            int front = q.poll();

            for(int neigh : edges[front]){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                    ans.add(neigh);
                }
            }
        }

        int ansArr[] = new int[ans.size()];
        int k = 0;
        for(int ele : ans){
            ansArr[k++] = ele;
        }

        return ansArr;
    }


}
