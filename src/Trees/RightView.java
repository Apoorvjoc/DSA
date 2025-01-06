package Trees;

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
