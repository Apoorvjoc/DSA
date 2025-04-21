package Trees;

import java.util.*;

public class BurnTree {
    public int amountOfTime(TreeNode root, int start) {
        int time = 0;
        if(root == null)return time;

        Map<Integer, List<Integer> > graph = new HashMap();
        graph.put(root.val , new ArrayList());
        constructGraphFromTree(root , graph);

        // apply bfs for graph:
        System.out.print(graph);

        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        Set<Integer> vis = new HashSet();
        vis.add(start);

        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0 ; i<n ; i++){
                int front = q.poll();
                List<Integer> list = graph.get(front);

                for(int ele : list){
                    if(!vis.contains(ele)){
                        q.add(ele);
                        vis.add(ele);
                    }
                }
            }
            time++;
        }

        return time - 1;
    }

    // if all vales of tree node are not same then we have to follow this
    private void constructGraphFromTree(TreeNode root , Map<Integer, List<Integer> > graph){// making graph from tree
        if(root == null)return;

        if(root.left != null){
            graph.putIfAbsent(root.left.val, new ArrayList<>());
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val); // making graph bi-directional
        }

        if(root.right != null){
            graph.putIfAbsent(root.right.val, new ArrayList<>());
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val); // making graph bi-directional
        }

        constructGraphFromTree(root.left , graph);
        constructGraphFromTree(root.right , graph);

    }

}


//approach 2 extension of burn tree
class burnTreeExtended{
    private TreeNode findNodeInTree(int start , TreeNode root){
        if(root == null)return null;

        if(root.val ==  start)return root;

        TreeNode left = findNodeInTree(start , root.left);
        TreeNode right = findNodeInTree(start , root.right);

        if(left != null)return left;
        if(right != null) return right;

        return null;
    }

    public int amountOfTime(TreeNode root, int start) {
        int ans = 0;
        if(root == null)return ans;

        TreeNode startNode = findNodeInTree(start , root); // as start is given in int therefore finding its address , as given in question all nodes are unique

        System.out.println(startNode.val);

        Map<TreeNode , TreeNode> mp = new HashMap();
        findParent(mp , root);

        Queue<TreeNode>q = new ArrayDeque();
        q.add(startNode);

        Set<TreeNode> vis = new HashSet();
        vis.add(startNode);

        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0 ; i<n ; i++){
                TreeNode front = q.poll();

                if(front.left != null && !vis.contains(front.left)){
                    q.add(front.left);
                    vis.add(front.left);
                }

                if(front.right != null && !vis.contains(front.right)){
                    q.add(front.right);
                    vis.add(front.right);
                }

                if(mp.containsKey(front)){
                    TreeNode parent = mp.get(front);
                    if(!vis.contains(parent)){
                        q.add(parent);
                        vis.add(parent);
                    }
                }
            }

            ans++;
        }

        return ans-1;
    }

    private void findParent(Map<TreeNode , TreeNode> mp , TreeNode root){

        if(root == null)return;

        if(root.left != null)mp.put(root.left , root);

        if(root.right != null)mp.put(root.right , root);

        findParent(mp , root.left);
        findParent(mp , root.right);


    }
}