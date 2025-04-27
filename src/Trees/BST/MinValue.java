package Trees.BST;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
/*
Important:

In BST, min value is found by only going left (no right turns).
In given tree, after 50, there is no left child.
So 50 is the minimum, without exploring right side.
But if tree is not a BST, and you have to find minimum among all nodes,
then you have to check entire tree (left and right).

So, values are:
[100, 90, 105, 50, 70, 60, 10]

And minimum among them = 10.
 */
public class MinValue {


    int minValue(TreeNode root) {
        // code s
        if (root == null) return -1; // or some default as per question

        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}


/*
If i/p : 100 90 105 50 95 N N N 60 10 N 5
gfg compiler gives value = 50 instead of 5 , acc to question leftmost node is min node.

 */
