package Trees;

import java.util.*;

public class BurnTree {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer , List<Integer>> parent = new HashMap();
        makeGraph(root , -1 , parent);

        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        Set<Integer> vis = new HashSet();
        vis.add(start);

        int time = 0;

        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0; i < n ; i++){
                Integer front = q.poll();
                List<Integer> li = parent.get(front);

                for(int x : li){
                    if(!vis.contains(x)){
                        vis.add(x);
                        q.add(x);
                    }
                }
            }
            time++;
        }

        return time-1;
    }

    private void makeGraph(TreeNode curr , int val , Map<Integer , List<Integer>> adj){
        if(curr == null)return;

        adj.putIfAbsent(curr.val , new ArrayList<>());

        //adding parent
        if(val != -1){
            adj.get(curr.val).add(val);
        }

        if(curr.left != null){
            adj.putIfAbsent(curr.left.val, new ArrayList<>());
            adj.get(curr.val).add(curr.left.val);
            adj.get(curr.left.val).add(curr.val);  // Add back the parent (bidirectional edge)
        }

        if(curr.right != null){
            adj.putIfAbsent(curr.right.val, new ArrayList<>());
            adj.get(curr.val).add(curr.right.val);
            adj.get(curr.right.val).add(curr.val);  // Add back the parent (bidirectional edge)
        }

        makeGraph(curr.left , curr.val , adj);
        makeGraph(curr.right , curr.val , adj);
    }
}
