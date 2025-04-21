package Graphs.ShortestPathAlgo.Dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class shortestPath {
    class Pair{
        int dist;
        int node;

        Pair(int dist , int node){
            this.dist = dist;
            this.node = node;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y) -> x.dist - y.dist);
        int src = 1;
        int distances[] = new int[n+1];

        Arrays.fill(distances , (int)1e9);
        distances[src] = 0;

        pq.add(new Pair(0 , src));

        while(!pq.isEmpty()){
            Pair front = pq.poll();
            int node = front.node;
            int dist = front.dist; // distance travelled till now

            for(int neigh[] : edges){
                int u = neigh[0];
                int v = neigh[1];
                int currDist = neigh[2];

                if(distances[node] > currDist + dist){
                    distances[node] = currDist + dist;
                    pq.add(new Pair(distances[node] , v));
                }
            }
        }


        return distances[n+1] == 1e9 ? List.of(-1) : List.of( distances[n+1] );

    }
}
