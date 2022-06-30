class Solution {
    List<Integer> ans = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0; i < l; i ++){
                TreeNode t = queue.remove();
                if(i == l - 1)
                    ans.add(t.val);
                if(t.left != null)
                    queue.add(t.left);
                if(t.right != null)
                    queue.add(t.right);
            }
        }
        return ans;
    }
}
