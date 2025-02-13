package Trees.BST;

public class KthSmallest {
    private TreeNode kthSmallest(TreeNode root, int k, int[] count) {
        if (root == null) return null;

        // Traverse left subtree
        TreeNode left = kthSmallest(root.left, k, count);
        if (left != null) return left; // If found in left subtree

        // Increment count after visiting the current node
        count[0]++;

        // If count equals k, return the current node
        if (count[0] == k) return root;

        // Traverse right subtree
        return kthSmallest(root.right, k, count);
    }
}
