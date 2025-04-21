package Graphs.CycleDetect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
Complexity:
Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisite pairs. This is because we iterate over all vertices and edges once.

Space Complexity: O(V + E) due to the space used for the graph and the queue.
 */
public class CourseScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // making adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int pair[] : prerequisites){
            adj.get(pair[0]).add(pair[1]);
        }
        int indegree[] = new int[numCourses];

        for(int i=0 ; i<numCourses ; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList();
        int cnt = 0;

        //adding nodes woth indegree in queue and array
        for(int i = 0 ; i<numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
                cnt++;
            }
        }

        //bfs algo for further checking
        while(!q.isEmpty()){
            int front = q.poll();

            for(int neigh : adj.get(front)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                    cnt++;
                }
            }
        }

        // if number of edges cnt size then there is no cycle
        if(numCourses == cnt)return true;

        return false;
    }
}

/*
why we can apply directly
for( int neigh :  graph[edge]) {

}

instead we need to create this adj list

 ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
 for(int i=0 ; i<numCourses ; i++){
    adj.add(new ArrayList<>());
 }

this is because we are given not given with correct number of edges
for example
1) numCourses = 2 and prerequisites = [[1,0]]
graph should be : [[], [0]]

2) numCourses = 6 prerequisites = [[5, 0], [5, 1], [5, 2], [5, 3]]
Graph should be : [[], [], [], [], [], [0, 1, 2, 3]]

3) numCourses = 6 prerequisites = [[1, 0], [2, 1], [3, 2], [1, 3]]
graph = [[], [0, 3], [1], [2], [], []]

that;s why algo will fail
lets take 1st eg while iterating for vertex = 1 out of bound occur b/c in prerequisite array there is noting for index 1

 */
