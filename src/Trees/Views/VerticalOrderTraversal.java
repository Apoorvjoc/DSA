package Trees.Views;

import Trees.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();

        Map<Integer , List<NodeWithDepth>> hm = new TreeMap(); //TreeMap log n compare to 0(1) of hashmap

        helper(root , hm , 0 , 0);

        for(Map.Entry<Integer , List<NodeWithDepth>> entry : hm.entrySet()){
            List<NodeWithDepth> nodesAtVertical = entry.getValue();
            // Sort first by depth, then by value
            Collections.sort(nodesAtVertical, (a, b) -> a.depth == b.depth ? a.val - b.val : a.depth - b.depth);

            List<Integer> verticalNodes = new ArrayList<>();
            for (NodeWithDepth node : nodesAtVertical) {
                verticalNodes.add(node.val);
            }
            res.add(new ArrayList(verticalNodes));
        }

        return res;
    }

    public void helper(TreeNode root , Map<Integer , List<NodeWithDepth>> hm , int vertical , int depth){
        if(root == null)return;

//        if (!hm.containsKey(vertical)) {
//            hm.put(vertical, new ArrayList<>());
//        }
//        hm.get(vertical).add(new NodeWithDepth(root.val, depth));


        hm.computeIfAbsent(vertical, k -> new ArrayList<>()).add(new NodeWithDepth(root.val , depth));

        helper(root.left , hm , vertical - 1 , depth + 1);
        helper(root.right , hm , vertical + 1 , depth + 1);
    }
}

class NodeWithDepth {
    int val;
    int depth;

    NodeWithDepth(int val, int depth) {
        this.val = val;
        this.depth = depth;
    }
}

