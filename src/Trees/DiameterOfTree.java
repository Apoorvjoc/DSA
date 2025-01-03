package Trees;
//https://leetcode.com/problems/diameter-of-binary-tree/description/
//TC : O(n*n)
public class DiameterOfTree {
    public int diameterOfBinaryTree_bruteforce(TreeNode root) {
        if(root == null)return 0;

        int lh = calcHeight(root.left);
        int rh = calcHeight(root.right);

        int ld = diameterOfBinaryTree_bruteforce(root.left);
        int rd = diameterOfBinaryTree_bruteforce(root.right);

        int diameter = Math.max(lh+rh , Math.max(ld , rd));

        return diameter;
    }

    private int calcHeight(TreeNode root){
        if(root == null)return 0;

        if(root.left == null && root.right == null)return 1;

        return Math.max(calcHeight(root.left) , calcHeight(root.right)) + 1;
    }
}

//TC: o (N)
class Diameter_optimal{
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = {0};
        if(root == null)return diameter[0];

        calcHeight(root , diameter);

        return diameter[0];
    }

    private int calcHeight(TreeNode root , int diameter[]){
        if(root == null)return 0;

        int lh =  calcHeight(root.left , diameter);
        int rh =  calcHeight(root.right , diameter);

        diameter[0] = Math.max(lh+rh , diameter[0]);

        return Math.max(rh , lh) + 1;
    }
}




