class SumBetweenTwoRanges {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                if(root.val >= low) {
                    root = root.left;
                } else {
                    break;
                }
            }
            root = stack.pop();
            if(root.val >= low && root.val <= high){
                sum+=root.val;
            }
            root = root.right;
        }
        return sum;
    }
}
