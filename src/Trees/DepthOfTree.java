package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class DepthOfTree {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 1;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left , right)+1;
    }
}

class DepthOfTree_BFS{
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);

        while(!q.isEmpty()){
            depth++;
            int n = q.size();

            for(int i = 0 ; i<n ; i++){
                TreeNode front = q.poll();

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
        }

        return depth;
    }
}
