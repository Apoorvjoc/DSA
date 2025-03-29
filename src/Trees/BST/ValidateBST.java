package Trees.BST;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList();
        isValidBST(root , inorder);

        //check for sorted and return ans
        for(int i = 0 ; i<inorder.size() - 1 ; i++){
            if(inorder.get(i) >= inorder.get(i+1))return false;
        }
        return true;
    }

    private void isValidBST(TreeNode root , List<Integer>inorder){
        if(root == null)return;

        isValidBST(root.left , inorder);
        inorder.add(root.val);
        isValidBST(root.right , inorder);
    }
}

//checking on the fly
class ValidateBST_approach2{
    public boolean isValidBST(TreeNode root) {
        List<Integer>inorder = new ArrayList();

        return isValidBST(root , inorder);
    }

    private boolean isValidBST(TreeNode root , List<Integer>inorder){
        if(root == null)return true;

        boolean left = isValidBST(root.left , inorder);

        if(inorder.size() > 0 && inorder.get(inorder.size() - 1) >= root.val)return false;

        inorder.add(root.val);

        boolean right = isValidBST(root.right , inorder);

        return left && right;
    }
}

// TC o(n)  , sc : o(h)
class validBST_App3{
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root , long min , long max){
        if(root == null)return true;

        if(root.val >= max || root.val <= min)return false;

        boolean left = isValidBST(root.left , min , root.val);
        boolean right = isValidBST(root.right , root.val , max);

        return left && right;
    }
}
