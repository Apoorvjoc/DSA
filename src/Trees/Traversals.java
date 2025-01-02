package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Tree{
    int data;
    Tree left;
    Tree right;

    Tree(int data , Tree left , Tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Tree (int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Traversals {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.right.left = new Tree(4);
        root.right.right = new Tree(5);

        List<Integer> ans = new ArrayList<>();

        preOrder(root , ans);
        System.out.println("Preorder: " + ans);
        ans = new ArrayList<>();

        inOrder(root , ans);
        System.out.println("InOrder: " + ans);
        ans = new ArrayList<>();

        postOrder(root , ans);
        System.out.println("Preorder: " + ans);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        System.out.println("Level Order: " + BFS_LvlOrder(root1));
    }

    private static void preOrder(Tree root, List<Integer> ans){
        if(root == null)return;

        ans.add(root.data);
        preOrder(root.left , ans);
        preOrder(root.right , ans);
    }

    private static void inOrder(Tree root , List<Integer>ans){
        if(root == null)return;

        inOrder(root.left , ans);
        ans.add(root.data);
        inOrder(root.right , ans);
    }

    private static void postOrder(Tree root , List<Integer>ans){
        if(root == null)return;

        postOrder(root.left , ans);
        postOrder(root.right , ans);
        ans.add(root.data);

    }

    private static List<List<Integer>> BFS_LvlOrder(TreeNode root) {

            List<List<Integer>> ans = new ArrayList();
            if(root == null)return ans;

            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()){
                List<Integer> level = new ArrayList();
                int n = q.size();

                for(int i = 0 ; i<n ; i++){ // travesing for each lvl
                    TreeNode front = q.poll();

                    level.add(front.val);

                    if(front.left != null){
                        q.add(front.left);
                    }
                    if(front.right != null){
                        q.add(front.right);
                    }
                }

                ans.add(level);

            }

            return ans;
        }


}
