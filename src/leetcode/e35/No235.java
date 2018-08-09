package leetcode.e35;

/**
 * Created by txwyy123 on 18/8/9.
 */
public class No235 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val))
            return root;

        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args){
        No235 no235 = new No235();
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        TreeNode n = no235.lowestCommonAncestor(n1, n4, n5);
        System.out.print(n.val);
    }
}
