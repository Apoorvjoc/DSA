package Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        if(root == null)return ans;
        helper(root , ans , "");
        return ans;
    }

    private void helper(TreeNode root , List<String> ans , String sAns){
        if(root == null)return;

        if(root.left == null && root.right == null){
            sAns+=root.val;
            ans.add(sAns);
            return;
        }

        helper(root.left , ans , sAns+root.val+"->");
        helper(root.right , ans , sAns+root.val+"->");
    }
}

//this approach is better than above (using string builder in case of string is always better)
class RootToLeafPath_stringBuilder {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        if(root == null)return ans;
        helper(root , ans , new StringBuilder());
        return ans;
    }

    private void helper(TreeNode root , List<String> ans , StringBuilder sAns){
        if(root == null)return;

        sAns.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(sAns.toString());
            return;
        }

        sAns.append("->");
        helper(root.left , ans , new StringBuilder(sAns));
        helper(root.right , ans , new StringBuilder(sAns));
    }
}
