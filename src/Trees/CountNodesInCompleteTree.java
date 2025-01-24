package Trees;

public class CountNodesInCompleteTree {
    //tc : o(n)
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

//approach 2 :o(logn)^2;
class CountNodes_Optimized{
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = calcLeftHeight(root);
        int rh = calcRightHeight(root);

        if(rh == lh) return (1 << lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int calcLeftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }

    private int calcRightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
}
