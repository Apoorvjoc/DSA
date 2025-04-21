package Trees.Views;

import Trees.Node;

import java.util.ArrayList;

public class BoundryTraversal {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        if (node == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Add the root node if it's not a leaf node
        if (node.left != null || node.right != null) {
            ans.add(node.data);
        }

        // Add the left boundary (excluding leaf nodes)
        leftBoundary(node.left, ans);

        // Add all leaf nodes
        leafNodes(node, ans);

        // Add the right boundary (excluding leaf nodes, and in reverse order)
        rightBoundary(node.right, ans);

        return ans;
    }

    private void leafNodes(Node root , ArrayList<Integer> temp){
        if(root == null)return;
        if(root.left == null && root.right == null)temp.add(root.data);

        leafNodes(root.left , temp);
        leafNodes(root.right , temp);
    }

    private void leftBoundary(Node root , ArrayList<Integer> temp){

        while(root != null){
            if(!(root.left == null && root.right == null))temp.add(root.data);// skip leaf node
            if(root.left != null)root = root.left;
            else root = root.right;
        }
    }

    private void rightBoundary(Node root , ArrayList<Integer> temp){
        ArrayList<Integer> res = new ArrayList();

        while(root != null){
            if(!(root.left == null && root.right == null))res.add(root.data);// skip leaf node
            if(root.right != null)root = root.right;
            else root = root.left;
        }
        // skip root and reverse list
        for(int i = res.size()-1 ; i>=0 ; i--){
            temp.add(res.get(i));
        }
    }
}
