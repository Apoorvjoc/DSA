package Trees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null)return false;
        else if(p != null && q == null)return false;
        else if(p == null && q == null) return true;
        else{
            if(p.val != q.val)return false;
            return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
        }
    }
}

class SameTree_app2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)return p == q;
        else if (p.val != q.val)return false;
        else{
            return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
        }
    }
}
