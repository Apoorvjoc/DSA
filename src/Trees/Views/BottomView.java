package Trees.Views;

import java.util.*;

//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomView {
    class Pair{
        int lvl;
        Node node;

        Pair(int lvl , Node node){
            this.lvl = lvl;
            this.node = node;
        }
    }
    public ArrayList<Integer> bottomView(Node node)
    {
        // Code here
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
                    mp.put(currLvl-1 , currNode.left.data);
                }

                if(currNode.right != null){
                    q.add(new Pair(currLvl + 1 , currNode.right));
                    mp.put(currLvl+1 , currNode.right.data);
                }
            }
        }

        for(Map.Entry<Integer , Integer> entry : mp.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}

class bottomView_anotherWay{
        static ArrayList<Integer> anotherway(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return ans;

            Map<Integer, Integer> map = new TreeMap<>(); // hd -> node value
            Queue<Trees.Views.topView_anotherway.Pair> q = new LinkedList<>();

            q.add(new Trees.Views.topView_anotherway.Pair(root, 0));

            while (!q.isEmpty()) {
                Trees.Views.topView_anotherway.Pair p = q.poll();
                Node curr = p.node;
                int line = p.hd;

//                if (!map.containsKey(line)) {
//                    map.put(line, curr.data);
//                }

                //cpmment above line and put values without check
                map.put(line, curr.data); // diff lines from top view

                if (curr.left != null) {
                    q.add(new Trees.Views.topView_anotherway.Pair(curr.left, line - 1));
                }
                if (curr.right != null) {
                    q.add(new Trees.Views.topView_anotherway.Pair(curr.right, line + 1));
                }
            }


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
