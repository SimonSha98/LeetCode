class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root.val == p.val || root.val == q.val)
            return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l == null){
            if(r == null){
                return null;
            } else if(r.val != p.val && r.val != q.val){
                return r;
            } else
                return root.val == p.val || root.val == q.val ? root : r;
        }
        else if(r == null){
            if(l.val != p.val && l.val != q.val)
                return l;
            else
                return root.val == p.val || root.val == q.val ? root : l;
        }
        return root;
    }
}
