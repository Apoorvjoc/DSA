package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_Traversals {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Preorder " + preorderTraversal(root));
        System.out.println("Inorder " + inorderTraversal(root));
        System.out.println("Postorder " + postorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root == null)return ans;

        Stack<TreeNode> st = new Stack();

        st.add(root);

        while(!st.isEmpty()){
            TreeNode top = st.pop();
            ans.add(top.val);

            //put right first
            if(top.right != null){
                st.add(top.right);
            }
            //then put left
            if(top.left != null){
                st.add(top.left);
            }

            //order is in this manner because preorder has (root , left , right)
            //so left tabhi phle aa payega if right is below left in stack
            //that's why right first then left
        }

        return ans;
    }

    //using 2 stacks
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root == null)return ans;
        Stack<TreeNode>st1 = new Stack();
        Stack<TreeNode>st2 = new Stack();
        st1.add(root);

        while(!st1.isEmpty()){
            TreeNode top = st1.pop();
            st2.add(top);
            if(top.left != null)st1.add(top.left);
            if(top.right != null)st1.add(top.right);
        }

        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }

        return ans;
    }

    //Inorder
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> st = new Stack();

        while(true){
            //**left
            if(root != null){ // traversing left side util null occurred at left
                st.add(root);
                root = root.left;
            }else{
                if(st.isEmpty())break;
                root = st.pop(); // once null occurred at left add element to ans list
                ans.add(root.val); // **data
                root = root.right; // **right
            }
        }

        return ans;
    }
}
