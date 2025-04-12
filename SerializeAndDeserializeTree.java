/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr!=null) {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("null");
            }
            sb.append(',');
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int i=0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(!nodes[i+1].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(nodes[i+1]));
                q.add(curr.left);
            }
            if(!nodes[i+2].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(nodes[i+2]));
                q.add(curr.right);
            }
            i = i+2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
