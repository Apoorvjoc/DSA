package Trees.BST;

public class SearchInBst {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)return null;

        return helper(root , val);
    }

    public TreeNode helper(TreeNode root, int val) {
        if(root == null)return null;
        if(root.val == val)return root;

        if(root.val < val) return helper(root.right , val);
        else return helper(root.left , val);

    }
}
