
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        return null;

        if(root.val==p.val||root.val==q.val)
        return root;

        TreeNode left_lca=lowestCommonAncestor(root.left,p,q);
        TreeNode right_lca=lowestCommonAncestor(root.right,p,q);

        if(left_lca!=null && right_lca!=null)
        return root;

        return (left_lca!=null)?left_lca:right_lca;




    }
}
