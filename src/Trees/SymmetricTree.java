package Trees;

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
}
