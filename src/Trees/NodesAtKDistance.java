package Trees;

import java.util.*;

public class NodesAtKDistance {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList();
        if(root == null)return ans;

        Map<TreeNode , TreeNode> mp = new HashMap(); // map of current node , parent;
        calcParent(root , mp);

        Set<TreeNode> vis = new HashSet();
        Queue<TreeNode>q = new ArrayDeque();
        q.add(target);
        vis.add(target);

        //apply bfs

        while(!q.isEmpty() && k > 0){
            int n = q.size();

            for(int i = 0 ; i<n ; i++){
                TreeNode front = q.poll();

                // left
                if(front.left != null && !vis.contains(front.left)){
                    vis.add(front.left);
                    q.add(front.left);
                }

                // right
                if(front.right != null && !vis.contains(front.right)){
                    vis.add(front.right);
                    q.add(front.right);
                }

                //parent
                if(mp.containsKey(front)){
                    TreeNode parent = mp.get(front);
                    if(!vis.contains(parent)){
                        vis.add(parent);
                        q.add(parent);
                    }
                }
            }
            k--;
        }

        //put remaining elements in ans array
        while(!q.isEmpty()){
            TreeNode front = q.poll();
            ans.add(front.val);
        }


        return ans;
    }

    private void calcParent(TreeNode root , Map<TreeNode , TreeNode> mp){
        if(root == null)return;

        if(root.left != null){
            mp.put(root.left , root); // root left has parent as root
        }

        if(root.right != null){
            mp.put(root.right , root); // root right has parent as root
        }

        calcParent(root.left , mp);
        calcParent(root.right , mp);
    }
}
