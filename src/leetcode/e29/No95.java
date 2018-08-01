package leetcode.e29;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/1.
 */
public class No95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n <= 0)
            return new ArrayList<>();

        return doGen(1, n);
    }

    private List<TreeNode> doGen(int left, int right){
        List<TreeNode> result = new ArrayList<>();
        if(left > right) {
            result.add(null);
            return result;
        }

        if(left == right) {
            result.add(new TreeNode(left));
            return result;
        }

        for(int i = left; i <= right; i++) {
            List<TreeNode> ls = doGen(left, i-1);
            List<TreeNode> rs = doGen(i+1, right);

            for(TreeNode l : ls){
                for(TreeNode r : rs){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        No95 no95 = new No95();
        System.out.print(no95.generateTrees(3));
    }
}
