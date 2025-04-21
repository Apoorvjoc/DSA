package Graphs.CycleDetect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Complexity:
Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisite pairs. This is because we iterate over all vertices and edges once.

Space Complexity: O(V + E) due to the space used for the graph and the queue.

 */
public class CourseSchedulingTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>ans = new ArrayList();
        ArrayList<ArrayList<Integer>> graph = new ArrayList();

        //making graph from given prerequisites array
        for(int i = 0 ; i<numCourses ; i++){
            graph.add(new ArrayList());
        }

        //adding vertices to graph ds
        for(int []edge : prerequisites ){
            graph.get(edge[1]).add(edge[0]); //as given to perform 0 we should have complete 1
        }

        int indegree[] = new int[numCourses];

        //setting indegree for graph
        for(int i = 0 ; i<numCourses ; i++){
            for(int node : graph.get(i)){
                indegree[node]++;
            }
        }

        //put all indgree with 0 in queue --starting point of bfs
        Queue<Integer> q = new LinkedList();
        int visVer = 0;
        for(int i = 0 ; i<numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
                ans.add(i);
                visVer++; // using this for final check
            }
        }

        //traversing queue
        while(!q.isEmpty()){
            int node = q.poll();

            for(int neigh : graph.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                    ans.add(neigh);
                    visVer++;
                }
            }
        }

        return visVer == numCourses ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
