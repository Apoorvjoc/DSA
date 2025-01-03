package Trees;

//https://leetcode.com/problems/balanced-binary-tree/description/
public class checkBakancedBT {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return -1 != calcHeight(root);
    }

    private int calcHeight(TreeNode root){
        if(root == null)return 0;

        if(root.left == null && root.right == null)return 1;

        int left = calcHeight(root.left);
        int right = calcHeight(root.right);

        if(left == -1 || right == -1) return -1;

        if(Math.abs(left - right) > 1)return -1;

        return Math.max(left , right) + 1;
    }
}

//TC : o(n*n)
//SC : o(n) auxiliary stack space
class BalanceBT{
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int lh = calcHeight(root.left);
        int rh = calcHeight(root.right);

        if(Math.abs(lh - rh) > 1)return false;

        Boolean left = isBalanced(root.left);
        Boolean right = isBalanced(root.right);

        return left && right;
    }

    private int calcHeight(TreeNode root){
        if(root == null)return 0;

        if(root.left == null && root.right == null)return 1;

        int left = calcHeight(root.left);
        int right = calcHeight(root.right);

        return Math.max(left , right) + 1;
    }
}
