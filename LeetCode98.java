class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return find(root);
    }
    private boolean find(TreeNode root){
        if(root == null)
            return true;
        if(!find(root.left))
            return false;
        if(prev != null && prev >= root.val)
            return false;
        prev = root.val;
        return find(root.right);
    }
}
