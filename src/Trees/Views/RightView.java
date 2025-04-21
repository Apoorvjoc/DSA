package Trees.Views;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList();
            helper(root , ans , 0);
            return ans;
    }

    private void helper(TreeNode root , List<Integer> ans , int lvl){
            if(root == null) return;

            if(lvl == ans.size())ans.add(root.val);

            helper(root.right , ans , lvl + 1);
            helper(root.left , ans , lvl + 1);
    }
}

class LeftView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        helper(root , ans , 0);
        return ans;
    }

    private void helper(TreeNode root , List<Integer> ans , int lvl){
        if(root == null) return;

        if(lvl == ans.size())ans.add(root.val);  // if entered lvl is eqls ds.size  indicates this is firtsr occurance from left side

        helper(root.left , ans , lvl + 1);
        helper(root.right , ans , lvl + 1);
    }
}
