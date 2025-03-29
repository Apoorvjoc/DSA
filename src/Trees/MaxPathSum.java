package Trees;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int maxVal[] = {Integer.MIN_VALUE};
        helper(root, maxVal);
        return maxVal[0];
    }
    public int helper(TreeNode root , int maxVal[]){
        if(root == null)return 0;


        //handling -ve sums by Math.max(0 , call) (this testcase will fail : ROOT = [2,-1])
        int left = Math.max(0 , helper(root.left , maxVal));
        int right =  Math.max(0 , helper(root.right , maxVal));

        maxVal[0] = Math.max(maxVal[0] , root.val+left+right);

        return root.val + Math.max(left , right);
    }
}

class MaxPathSum_ {
    public int maxPathSum(TreeNode root) {
        int maxVal[] = {Integer.MIN_VALUE};
        helper(root, maxVal);
        return maxVal[0];
    }
    public int helper(TreeNode root , int maxVal[]){
        if(root == null)return 0;


        //handling -ve sums by Math.max(0 , call) (this testcase will fail : ROOT = [2,-1])
        int left = Math.max(0 , helper(root.left , maxVal));
        int right =  Math.max(0 , helper(root.right , maxVal));

        maxVal[0] = Math.max(maxVal[0] , root.val+left+right);

        return root.val + Math.max(left , right);
    }
}
