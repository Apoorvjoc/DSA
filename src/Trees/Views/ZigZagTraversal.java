package Trees.Views;

import Trees.TreeNode;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftToRight = true;
        List<List<Integer>> ans = new ArrayList();
        if(root == null)return ans;

        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            List<Integer>sAns = new ArrayList();

            for(int i = 0 ; i < n ; i++){
                TreeNode front = q.poll();
                sAns.add(front.val);
                if(front.left != null)q.add(front.left);
                if(front.right != null)q.add(front.right);
            }

            if(!leftToRight){ // thing which is diff from level order traversal
                Collections.reverse(sAns);
            }

            ans.add(sAns);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}
