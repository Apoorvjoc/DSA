package Trees.Views;


//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
import java.util.*;

class Pair{
    int lvl;
    Node node;

    Pair(int lvl , Node node){
        this.lvl = lvl;
        this.node = node;
    }
}

// using recursion we need to use one for variable i.e height and lvl with min height should be stored in the map
public class TopView {
    public ArrayList<Integer> topViewOfBT(Node node){
        ArrayList<Integer> ans = new ArrayList<>();

        if(node == null)return ans;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0 , node));

        Map<Integer , Integer> mp = new TreeMap<>(); // map of lvl and node val
        mp.put(0 , node.data);

        while (!q.isEmpty()){
            int n = q.size();

            for(int i = 0 ; i<n ; i++){
                Pair front = q.poll();
                Node currNode = front.node;
                int currLvl = front.lvl;

                if(currNode.left != null){
                    q.add(new Pair(currLvl - 1 , currNode.left));
                    if(!mp.containsKey(currLvl-1)){
                        mp.put(currLvl-1 , currNode.left.data);
                    }
                }

                if(currNode.right != null){
                    q.add(new Pair(currLvl + 1 , currNode.right));
                    if(!mp.containsKey(currLvl+1)){
                        mp.put(currLvl+1 , currNode.right.data);
                    }
                }
            }
        }

        for(Map.Entry<Integer , Integer> entry : mp.entrySet()){
          ans.add(entry.getValue());
        }

        return ans;
    }
}

// no impact of tc ans sc
class topView_anotherway {
    static ArrayList<Integer> topView_anotherway(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>(); // hd -> node value
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int line = p.hd;

            if (!map.containsKey(line)) {
                map.put(line, curr.data);
            }

            if (curr.left != null) {
                q.add(new Pair(curr.left, line - 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, line + 1));
            }
        }


//        for (int val : map.values()) {
//            ans.add(val);
//        }
        ans.addAll(map.values()); // commented code is similar to what we have done here

        return ans;
    }

    // Helper class to represent node + horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
}


class dfs_approach{
    static ArrayList<Integer> topView(Node root) {
        Map<Integer, Pair_dfs> map = new TreeMap<>(); // hd -> (node val, level)
        dfs(root, 0, 0, map); // node, hd, level, map

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Pair_dfs> entry : map.entrySet()) {
            ans.add(entry.getValue().val);
        }

        return ans;
    }

    // DFS helper function
    private static void dfs(Node node, int hd, int level, Map<Integer, Pair_dfs> map) {
        if (node == null) return;

        // if hd is not seen before, or current level is smaller (i.e., node is higher)
        if (!map.containsKey(hd) || map.get(hd).level > level) {
            map.put(hd, new Pair_dfs(node.data, level));
        }

        dfs(node.left, hd - 1, level + 1, map);
        dfs(node.right, hd + 1, level + 1, map);
    }

    // Custom Pair class
    static class Pair_dfs {
        Integer val;
        Integer level;
        Pair_dfs(Integer v, Integer l) {
            val = v;
            level = l;
        }
    }

}
