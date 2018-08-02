package leetcode.e30;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/2.
 */
public class No337 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Result{
        int sum;
        boolean isRootRobbed;

        Result(){}

        Result(int sum, boolean isRootRobbed){
            this.sum = sum;
            this.isRootRobbed = isRootRobbed;
        }
    }

    public int rob(TreeNode root) {
        if(root == null)
            return 0;

        Map<TreeNode, Result> unRobbedMap = new HashMap<>();
        Map<TreeNode, Result> robbedMap = new HashMap<>();
        Result result = doRob(root, true, unRobbedMap, robbedMap);
        Result result1 = doRob(root, false, unRobbedMap, robbedMap);

        return Math.max(result.sum, result1.sum);
    }

    private Result doRob(TreeNode root, boolean isRootRobbed, Map<TreeNode, Result> unRobbedMap, Map<TreeNode, Result> robbedMap){
        if(root == null)
            return new Result(0, false);

        Result result = new Result();
        if(isRootRobbed) {
            if(robbedMap.containsKey(root)){
                result = robbedMap.get(root);
            }else {
                Result left = doRob(root.left, false, unRobbedMap, robbedMap);
                Result right = doRob(root.right, false, unRobbedMap, robbedMap);
                result.sum = root.val + left.sum + right.sum;
                result.isRootRobbed = true;
                robbedMap.put(root, result);
            }
        }else{
            if(unRobbedMap.containsKey(root)){
                result = unRobbedMap.get(root);
            }else {
                Result left1 = doRob(root.left, false, unRobbedMap, robbedMap);
                Result left2 = doRob(root.left, true, unRobbedMap, robbedMap);
                Result left = new Result();
                if (left1.sum >= left2.sum) {
                    left.sum = left1.sum;
                    left.isRootRobbed = false;
                } else {
                    left.sum = left2.sum;
                    left.isRootRobbed = true;
                }

                Result right1 = doRob(root.right, false, unRobbedMap, robbedMap);
                Result right2 = doRob(root.right, true, unRobbedMap, robbedMap);
                Result right = new Result();
                if (right1.sum >= right2.sum) {
                    right.sum = right1.sum;
                    right.isRootRobbed = false;
                } else {
                    right.sum = right2.sum;
                    left.isRootRobbed = true;
                }

                result.sum = left.sum + right.sum;
                result.isRootRobbed = false;

                unRobbedMap.put(root, result);
            }
        }

        return result;
    }

    public static void main(String[] args){
        No337 no337 = new No337();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        System.out.print(no337.rob(n1));
    }
}
