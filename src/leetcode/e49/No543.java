package leetcode.e49;

/**
 * Created by txwyy123 on 18/8/24.
 */
public class No543 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int result = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        countNode(root);
        return result-1;
    }

    int countNode(TreeNode root){
        if(root == null)
            return 0;
        int left = countNode(root.left);
        int right = countNode(root.right);
        result = Math.max(result, left+right+1);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args){
        No543 no543 = new No543();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.print(no543.diameterOfBinaryTree(n1));
    }
}
