package Graphs.ShortestPathAlgo.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
public class WithPQ {
    class Pair{
        int distance;
        int node;

        Pair(int distance , int node){
            this.distance = distance;
            this.node = node;
        }
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
        // Write your code here
        int v = adj.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        //PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y) -> x.distance - y.distance); above 2 are same
        int distance[] = new int[v];

        Arrays.fill(distance , (int)1e9);

        distance[src] = 0;
        pq.add(new Pair(0 , src));

        while(!pq.isEmpty()){
            Pair front = pq.poll();
            int dist = front.distance;
            int node = front.node;

            for(Pair neigh : adj.get(node)){
                int currDist = neigh.distance;
                int currNode = neigh.node;

                // these commented lines are incorrect code , as this is will grow pq endlessly
                // distance[currNode] = Math.min(currDist + dist , distance[currNode]);
                // pq.add(new Pair(distance[currNode] , currNode));

                if (distance[currNode] > dist + currDist) {
                    distance[currNode] = dist + currDist;
                    pq.add(new Pair(distance[currNode], currNode));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int wt : distance){
            ans.add(wt);
        }

        return ans;
    }
}
