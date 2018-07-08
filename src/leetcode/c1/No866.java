package leetcode.c1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by txwyy123 on 18/7/8.
 */
public class No866 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Result{
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth){this.node = node; this.depth = depth;}
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return doSub(root, 0).node;
    }

    private Result doSub(TreeNode root, int height){
        if(root == null) {
            return new Result(null, height);
        }

        Result lResult = doSub(root.left, height+1);
        Result rResult = doSub(root.right, height+1);

        if(lResult.depth > rResult.depth){
            return lResult;
        }else if(lResult.depth == rResult.depth){
            return new Result(root, lResult.depth);
        }else{
            return rResult;
        }

    }

    public static void main(String[] args){
        No866 no866 = new No866();
        Integer[] a = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = no866.build(a);
        System.out.println(root);
        TreeNode node = no866.subtreeWithAllDeepest(root);
        System.out.println(node.val);
    }

    private TreeNode build(Integer[] a){
        int num = 1;
        List<TreeNode> up = new ArrayList<>();
        List<TreeNode> down = new ArrayList<>();
        TreeNode root = null;

        int index = 0;
        do {
            for (int i = 0; i < num && index < a.length; i++) {
                if(a[index] == null)
                    down.add(null);
                else
                    down.add(new TreeNode(a[index]));
                index++;
            }

            if(up.isEmpty()){
                root = down.remove(0);
                up.add(root);
            }else{
                int j = 0;
                for(TreeNode node : up){
                    if(node != null) {
                        if (j < down.size()) {
                            node.left = down.get(j);
                            j++;
                        }
                        if (j < down.size()) {
                            node.right = down.get(j);
                            j++;
                        }
                    }
                }
                up.clear();
                up.addAll(down);
                down.clear();
            }
            num = num << 1;
        }while (index < a.length);

        return root;
    }
}
