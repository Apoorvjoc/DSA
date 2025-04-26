package Trees;

/*
    ✅ Time Complexity:
    O(N) — every node is visited and modified exactly once.
    ✅ Space Complexity:
    O(1) — no stack, no recursion, only constant pointers (curr, rightMost).
 */
public class FlattenBTtoLL {
    private TreeNode findRightMostNode(TreeNode left){
        while(left.right != null){
            left = left.right;
        }
        return left;
    }

    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                curr = curr.right; // to be noted
            }else{
                TreeNode rightMostNode = findRightMostNode(left);
                rightMostNode.right = curr.right;
                curr.right = curr.left;
                curr.left = null; // mark left as null as given in problem stmt
            }
        }
    }

    // --------- recursive code ------------------

    /*
    ✅ Time Complexity (TC):
    O(N)

    Each node is visited exactly once (processing left, right, and rearranging pointers).
    ✅ Space Complexity (SC):
    O(N) (due to recursion stack)

    In the worst case (for a skewed tree — like a linked list), the recursion depth becomes N.
    In a balanced tree, it would be O(log N), but worst-case we assume O(N).

     */
    private TreeNode prev = null;

    private void recursiveCode(TreeNode root ){
        if (root == null)return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
