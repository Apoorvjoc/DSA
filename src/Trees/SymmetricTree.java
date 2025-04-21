package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode rootLeft, TreeNode rootRight) {
        // If both are null, trees are symmetric at this level
        if (rootLeft == null && rootRight == null) return true;
        // If one is null and the other is not, trees are not symmetric
        if (rootLeft == null || rootRight == null) return false;

        // Check if values are the same and recursively check both subtrees
        if (rootLeft.val != rootRight.val) return false;

        // Recursively check the left and right subtrees for symmetry
        boolean first = helper(rootLeft.left, rootRight.right);
        boolean second = helper(rootLeft.right, rootRight.left);

        return first && second;
    }

    //app 2
    public boolean isSymmetric_2(TreeNode root) {
        if(root == null)return true;

        return checkSymmetry(root.left , root.right);
    }

    private boolean checkSymmetry(TreeNode left , TreeNode right){
        if(left == null || right == null)return left == right;
        if(left.val != right.val)return false;

        return checkSymmetry(left.left , right.right) &&  checkSymmetry(left.right , right.left);

    }
}

/*
We use a queue to simulate recursion. At each step, we compare two nodes: they should be mirror images, so:
One node must be the left child from the left subtree.
The other must be the right child from the right subtree.

🔍 How It Works:
Pairs of nodes are compared (left of left subtree vs. right of right subtree).
We add nodes to the queue in mirror order.
If all pairs match up correctly, the tree is symmetric.


 */
class leetcode_followUp{
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            // Add nodes in mirror order
            q.add(left.left);
            q.add(right.right);

            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }

}
