/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root, 0));
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> curr = q.poll();
            TreeNode currNode = curr.getKey();
            int col = curr.getValue();
            minCol = Math.min(col, minCol);
            maxCol = Math.max(col, maxCol);
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(currNode.val);
            if (currNode.left != null) {
                q.add(new Pair<TreeNode, Integer>(currNode.left, col - 1));
            }

            if (currNode.right != null) {
                q.add(new Pair<TreeNode, Integer>(currNode.right, col + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
