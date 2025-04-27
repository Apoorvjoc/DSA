package Trees.BST;

public class CeilAndFloor {
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int ans[] = {-1};
        helper(root , key , ans);
        return ans[0];
    }

    private void helper(Node root , int key , int[] ans){
        if(root == null) return;

        if(root.data >= key){
            ans[0] = root.data;
            helper(root.left , key , ans);
        }else{
            helper(root.right , key , ans);
        }
    }

    public static int floor(Node root, int x) {
        // Code here
        int ans[] = {-1};
        helper_floor(root , x , ans);
        return ans[0];
    }

    private static void helper_floor(Node root , int key , int[] ans){
        if(root == null) return;

        if(root.data > key){
            helper_floor(root.left , key , ans);
        }else{
            ans[0] = root.data;
            helper_floor(root.right , key , ans);
        }
    }
}

class iterative{
    public int floorInBST(TreeNode root, int key) {
        int floor = -1; // or Integer.MIN_VALUE based on requirement

        while (root != null) {
            if (root.val == key) {
                return root.val; // Exact match
            }
            if (root.val > key) {
                root = root.left; // move left
            } else {
                floor = root.val; // possible floor
                root = root.right; // move right to find closer value
            }
        }

        return floor;
    }

}
