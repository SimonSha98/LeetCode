class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(preorder[0]);
        int index = 0;
        for(int i = 0; i < inorder.length; i ++){
            if(inorder[i] == preorder[0]){
                index = i;
                break;
            }
        }
        TreeNode left = null;
        TreeNode right = null;
        if(index != 0){
            int[] inleft = Arrays.copyOfRange(inorder, 0, index);
            int[] preleft = Arrays.copyOfRange(preorder, 1, index + 1);
            left = buildTree(preleft, inleft);
        }
        if(index != inorder.length - 1){
            int[] inright = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            int[] preright = Arrays.copyOfRange(preorder, index + 1, preorder.length);
            right = buildTree(preright, inright);
        }
        head.left = left;
        head.right = right;
        return head;
    }
}
