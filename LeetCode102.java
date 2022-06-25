class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            List<Integer> cur = new LinkedList();
            for(int i = 0; i < l; i ++){
                TreeNode t = queue.remove();
                cur.add(t.val);
                if(t.left != null)
                    queue.add(t.left);
                if(t.right != null)
                    queue.add(t.right);
            }
            ans.add(cur);
        }
        return ans;
    }
}
