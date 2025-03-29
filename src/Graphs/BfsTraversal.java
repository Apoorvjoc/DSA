package Graphs;

import java.util.*;


//TC : o(Nodes + 2*Edges) => o(n+2e) , SC : 0(N) for    queue
public class BfsTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new ArrayDeque<>();
        int vis[] = new int[V];
        q.add(0);
        vis[0] = 1;
        ArrayList<Integer>ans = new ArrayList();
        ans.add(0);

        while(!q.isEmpty()){
            int front = q.poll();
            ArrayList<Integer>subList = adj.get(front);

            for(int i = 0 ; i<subList.size() ; i++){
                int currNode = subList.get(i);
                if(vis[currNode] == 0){
                    ans.add(currNode);
                    q.add(currNode);
                    vis[currNode] = 1;
                }
            }

        }

        return ans;
    }

    public ArrayList<Integer> bfsOfGraph_cleanCode(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new ArrayDeque<>();
        int vis[] = new int[V];
        q.add(0);
        vis[0] = 1;
        ArrayList<Integer>ans = new ArrayList();


        while(!q.isEmpty()){
            int front = q.poll();
            ans.add(front);

//            ArrayList<Integer> subList = adj.get(front);

//            for(int i = 0 ; i<subList.size() ; i++){
//                int currNode = subList.get(i);
//                if(vis[currNode] == 0){
//                    q.add(currNode);
//                    vis[currNode] = 1;
//                }
//            }
            // above commented code can be written as :

            for(Integer currNode : adj.get(front)){
//                int currNode = subList.get(i);
                if(vis[currNode] == 0){
                    q.add(currNode);
                    vis[currNode] = 1;
                }
            }

        }

        return ans;
    }
}
