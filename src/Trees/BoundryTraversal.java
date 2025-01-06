package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        addLeftBoundary(node.left, ans);

        // Add all leaf nodes
        addLeafNodes(node, ans);

        // Add the right boundary (excluding leaf nodes, and in reverse order)
        addRightBoundary(node.right, ans);

        return ans;
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> ans) {
        while (node != null) {
            if (node.left != null || node.right != null) {
                ans.add(node.data);
            }
            if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                break; // leaf node
            }
        }
    }

    private void addLeafNodes(Node node, ArrayList<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }
        // Recur for left and right subtrees
        addLeafNodes(node.left, ans);
        addLeafNodes(node.right, ans);
    }

    private void addRightBoundary(Node node, ArrayList<Integer> ans) {
        List<Integer> rightBoundary = new ArrayList<>();
        while (node != null) {
            if (node.left != null || node.right != null) {
                rightBoundary.add(node.data);
            }
            if (node.right != null) {
                node = node.right;
            } else if (node.left != null) {
                node = node.left;
            } else {
                break; // leaf node
            }
        }
        // Add right boundary in reverse order
        Collections.reverse(rightBoundary);
        ans.addAll(rightBoundary);
    }
}
