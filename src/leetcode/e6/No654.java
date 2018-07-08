package leetcode.e6;

/**
 * Created by txwyy123 on 18/7/8.
 */
public class No654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        return doContruct(nums, 0, nums.length-1);
    }

    private TreeNode doContruct(int[] nums, int start, int end){
        if(start > end)
            return null;

        int maxIndex = start;
        for(int i = start; i <= end; i++){
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        TreeNode left = doContruct(nums, start, maxIndex-1);
        TreeNode right = doContruct(nums, maxIndex+1, end);
        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = left;
        root.right = right;

        return root;
    }
}
