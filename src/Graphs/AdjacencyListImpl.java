package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListImpl {

    public static void main(String[] args) {
        int V = 5, E = 7;
        int edges[][] = {{0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}};
        List<List<Integer>> graph = printGraph(V , edges);
        System.out.println(graph);
    }

    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> graph = new ArrayList();
        int e = edges.length;
        //add number of edges
        for(int node = 0 ; node < V ; node ++){
            graph.add(node , new ArrayList());
        }

        for(int edge = 0 ; edge < e ; edge ++){
            graph.get(edges[edge][0]).add(edges[edge][1]);
            graph.get(edges[edge][1]).add(edges[edge][0]);
        }


        return graph;

    }
}
