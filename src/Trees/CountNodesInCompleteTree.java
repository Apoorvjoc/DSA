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
// log(n) for height
// log(n) for traversing
class CountNodes_Optimized{
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = calcLeftHeight(root);
        int rh = calcRightHeight(root);

        if(rh == lh) return (1 << lh) - 1; // => 2^h - 1   ==> dry run this formula for different examples

        return 1 + countNodes(root.left) + countNodes(root.right);
        // formula to calc nodes in BT => [ ans = currNode(1)  +  (2^leftHeight - 1) + (2^rightHeight - 1)  ];
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
