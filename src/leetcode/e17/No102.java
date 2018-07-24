package leetcode.e17;

import leetcode.c1.No866;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/24.
 */
public class No102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while(true) {
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            while (!list.isEmpty()) {
                TreeNode node = list.remove(0);
                temp.add(node.val);
                if(node.left != null)
                    next.add(node.left);
                if(node.right != null)
                    next.add(node.right);
            }
            result.add(temp);

            if(next.isEmpty())
                break;
            list.addAll(next);
            next.clear();
        }

        return result;
    }
}
