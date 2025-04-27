package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// tc : o(n) sc : o(1)
public class MorrisTraversal {
    private TreeNode getRightmostNode(TreeNode left , TreeNode curr){
        while(left.right != null && left.right != curr){
            left = left.right;
        }
        return left;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        TreeNode curr = root;

        while(curr!=null){
            TreeNode left = curr.left;
            if(left == null){ // if left is null then put left in ans
                ans.add(curr.val);
                curr=curr.right;
            }else { // if there is right node , it not then thread should be definitely present there from right
                TreeNode rightMostNode = getRightmostNode(left , curr);

                if(rightMostNode.right != curr){ // we are visiting first time therefore create thread
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else  { // if right is pointing to curr then there is a thread therefore add into ans and cut the thread
                    ans.add(curr.val);
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        TreeNode curr = root;

        while(curr!=null){
            TreeNode left = curr.left;
            if(left == null){ // if left is null then put left in ans
                ans.add(curr.val);
                curr=curr.right;
            }else { // if there is right node , it not then thread should be definitely present there from right
                TreeNode rightMostNode = getRightmostNode(left , curr);

                if(rightMostNode.right != curr){ // we are visiting first time therefore create thread
                    ans.add(curr.val); // diff line
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else  { // if right is pointing to curr then there is a thread therefore add into ans and cut the thread
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }

        }

        return ans;
    }
}

class postOrderTraversal{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){
            TreeNode  right = curr.right;
            if(right == null){
                ans.add(curr.val);
                curr = curr.left;
            }else {
                TreeNode leftMostNode = getLeftMostNode(right , curr);

                if(leftMostNode.left != curr){
                    leftMostNode.left = curr; // create thread
                    curr = curr.right;
                }else{
                    leftMostNode.left = null; //remove thread
                    ans.add(curr.val);
                    curr = curr.left;
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    private TreeNode getLeftMostNode(TreeNode right, TreeNode curr) {
        while(right.left != null && right.left != curr){
            right = right.left;
        }
        return right;
    }
}
