package Trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer , Integer> mp = new HashMap();
        for(int i = 0 ; i<n ; i++){
            mp.put(inorder[i] , i);
        }

        return constructTree(postorder , 0 , n-1 , inorder , 0 , n-1 ,  mp);
    }

    private TreeNode constructTree(int postorder[] , int postStartIdx , int postEndIdx , int inorder[] , int inStartIdx , int inEndIdx ,   Map<Integer , Integer> mp){
        if(postStartIdx > postEndIdx || inStartIdx > inEndIdx)return null;

        int element = postorder[postEndIdx];
        TreeNode root = new TreeNode(element);
        int inoderRootIdx = mp.get(element);
        int numberOfElementInLeftSubTree = inoderRootIdx - inStartIdx;

        root.left = constructTree(postorder , postStartIdx , postStartIdx + numberOfElementInLeftSubTree - 1 , inorder , inStartIdx ,  inoderRootIdx - 1, mp);
        root.right = constructTree(postorder , postStartIdx + numberOfElementInLeftSubTree , postEndIdx - 1 , inorder , inoderRootIdx + 1 , inEndIdx , mp);

        return root;
    }
}
