package Trees.BST;

import Trees.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);

        helper(root , val);

        return root;
    }

    private void helper(TreeNode root , int val){
        if(root.left == null || root.right == null){
            if(root.val < val && root.right == null){
                root.right = new TreeNode(val);
                return; // once inserted return
            }else if(root.val > val && root.left == null){
                root.left = new TreeNode(val);
                return; // once inserted return
            }
            //if not all above condition then current node is not correct place to insert move to code once more to find ideal position
        }

        if(root.val > val)helper(root.left , val);
        else helper(root.right , val);
    }

    //TODO Try with iterative approach
}
