package Trees;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList();
        List<TreeNode>fl = new ArrayList();
        List<TreeNode>sl = new ArrayList();

        rootToNodePath(root , p , l1 , fl);
        l1 = new ArrayList();
        rootToNodePath(root , q , l1 , sl);

        // extra operation
        int n = Math.min(fl.size() , sl.size());

        for(int i = n-1 ; i>= 0 ; i--){
            System.out.println(fl.get(i).val+" - "+sl.get(i).val+" ; ");
            if(fl.get(i) == sl.get(i))return fl.get(i);
        }

//        for(TreeNode n1 : fl){
//            System.out.print(n1.val+" -> ");
//        }
//
//        System.out.println();
//
//        for(TreeNode n1 : sl){
//            System.out.print(n1.val+" -> ");
//        }

        return root;
    }

    private void rootToNodePath(TreeNode root , TreeNode node , List<TreeNode>l , List<TreeNode> f){
        if(root == null)return;

        l.add(root);
        if(root == node){
            f.addAll(l);
            return;
        }

        rootToNodePath(root.left , node , l , f);
        rootToNodePath(root.right , node , l , f);

        //if we are at leaf node remove last element from list (left and right call both are over)
        l.remove(l.size()-1);

    }

    //approach 2 :
    class LCA_2{
        //Striver video
    }


    // lCA optimal
    //TC : o(n) , SC : o(n)
    class LCA_optimal {
        private TreeNode helper(TreeNode root , TreeNode node1 , TreeNode node2){
            if(root == null)return null;

            if(root == node1 || root == node2)return root;

            TreeNode left = helper(root.left , node1 , node2);
            TreeNode right = helper(root.right , node1 , node2);

            if(left != null && right == null)return left;
            else if(left == null && right != null)return right;
            else if(left != null && right != null) return root;
            return null;
        }
    }

}
