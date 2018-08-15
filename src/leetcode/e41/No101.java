package leetcode.e41;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/15.
 */
public class No101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return doJudge(root.left, root.right);
    }

    boolean doJudge(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;

        if(left != null && right != null && left.val == right.val)
            return doJudge(left.left, right.right) && doJudge(left.right, right.left);

        return false;
    }

    public static void main(String[] args) {
        No101 no101 = new No101();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        System.out.print(no101.isSymmetric(n1));
    }
}
