package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializeAndDeserializeBT {
    public String serialize(TreeNode root) {
        if(root == null)return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode>q = new ArrayDeque();
        q.add(root);
        str.append(root.val).append(",");

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i<n ; i++){
                TreeNode front = q.poll();
                if(front.left != null){
                    q.add(front.left);
                    str.append(front.left.val).append(",");
                }else{
                    str.append("#,");
                }

                if(front.right != null){
                    q.add(front.right);
                    str.append(front.right.val).append(",");
                }else{
                    str.append("#,");
                }
            }
        }
        System.out.println("Str " + str.toString());
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;

        String values[] = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i<data.length()){

            TreeNode front = q.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                front.left = left;
                q.add(left);
            }
            i++;
            if(i<data.length() && !values[i].equals("#")){
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                front.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }
}
