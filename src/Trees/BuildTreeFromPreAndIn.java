package Trees;

import java.util.HashMap;
import java.util.Map;


/*
✅ Time Complexity (TC): O(N)
You visit each node exactly once to build the tree.
Map lookup (mp.get(...)) is O(1) on average due to the hash map.
So, total time is proportional to the number of nodes → O(N), where N is the number of nodes in the tree.

✅ Space Complexity (SC): O(N)
Recursive stack space in the worst case is O(N) (when the tree is completely unbalanced, like a skewed tree).
HashMap space is O(N) for storing inorder indices.
Total space = map + recursion stack → O(N)
 */
public class BuildTreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder ) {
        int preorderIdx = 0;
        int n = inorder.length;
        Map<Integer , Integer> mp = new HashMap();
        for(int i = 0 ; i<n ; i++){
            mp.put(inorder[i] , i);
        }

        return constructTree(preorder , 0 , n-1 , inorder , 0 , n-1 ,  mp);
    }

    private TreeNode constructTree(int []preorder , int preStartIdx , int preEndIdx , int[] inorder , int inStartIdx , int inEndIdx ,  Map<Integer , Integer> mp){
        if(preStartIdx > preEndIdx || inStartIdx > inEndIdx)return null;

        //create root
        int element = preorder[preStartIdx];
        TreeNode root = new TreeNode(element);
        int rootIdxInorder = mp.get(element);
        int numberOfElementsLeftofArray = rootIdxInorder - inStartIdx;  // number of element in left side will be section of inorder from inorder start idx till root element found

        root.left = constructTree(preorder , preStartIdx + 1 , preStartIdx + numberOfElementsLeftofArray , inorder , inStartIdx , rootIdxInorder - 1 , mp);
        root.right = constructTree(preorder , preStartIdx + numberOfElementsLeftofArray + 1 , preEndIdx , inorder , rootIdxInorder + 1 , inEndIdx , mp);

        return root;
    }
}
