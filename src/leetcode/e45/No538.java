package leetcode.e45;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/21.
 */
public class No538 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;

        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);

        return root;
    }

    public static void main(String[] args){
        No538 no538 = new No538();
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(-4);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        TreeNode root = no538.convertBST(n1);
        System.out.print(root);

    }
}
