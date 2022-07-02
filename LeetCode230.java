class Solution {
    private List<Integer> ans;
    public int kthSmallest(TreeNode root, int k) {
        ans = new ArrayList();
        dfs(root);
        return ans.get(k-1);
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
