package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

class Pair{
    TreeNode node;
    int idx;

    Pair(TreeNode node , int idx){
        this.node = node;
        this.idx = idx;
    }
}

public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque();
        q.add(new Pair(root , 0));
        int maxWidth = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int n = q.size();
            int minIdx = 0 , maxIdx = -1;
//            int mmin = q.peek().idx;

            for(int i = 0 ; i<n ; i++){
                Pair front = q.poll();
                TreeNode frontNode = front.node;

                System.out.print("Checking for node : " + frontNode.val+" and idx " + front.idx +" ");
                int currIdx = front.idx;
                if(i == 0){
                    minIdx = currIdx;
                }
                if(i == n-1){
                    maxIdx = currIdx;
                }


                if(frontNode.left != null){
                    int idx = 2*currIdx + 1;
                    q.add(new Pair(frontNode.left , idx));
                }
                if(frontNode.right != null){
                    int idx = 2*currIdx + 2;
                    q.add(new Pair(frontNode.right , idx));
                }
            }
            System.out.println();
            maxWidth = Math.max(maxWidth , maxIdx - minIdx + 1);
        }

        return maxWidth;
    }
}

//added mmin concept
class WidthOfBinaryTree_optimal {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque();
        q.add(new Pair(root , 0));
        int maxWidth = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int n = q.size();
            int minIdx = 0 , maxIdx = -1;
            int mmin = q.peek().idx; // optimization for skewed tree

            for(int i = 0 ; i<n ; i++){
                Pair front = q.poll();
                TreeNode frontNode = front.node;

                System.out.print("Checking for node : " + frontNode.val+" and idx " + front.idx +" ");
                int currIdx = front.idx-mmin;
                if(i == 0){
                    minIdx = currIdx;
                }
                if(i == n-1){
                    maxIdx = currIdx;
                }


                if(frontNode.left != null){
                    int idx = 2*currIdx + 1;
                    q.add(new Pair(frontNode.left , idx));
                }
                if(frontNode.right != null){
                    int idx = 2*currIdx + 2;
                    q.add(new Pair(frontNode.right , idx));
                }
            }
            System.out.println();
            maxWidth = Math.max(maxWidth , maxIdx - minIdx + 1);
        }

        return maxWidth;
    }
}
