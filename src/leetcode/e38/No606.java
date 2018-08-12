package leetcode.e38;

/**
 * Created by txwyy123 on 18/8/12.
 */
public class No606 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String tree2str(TreeNode t) {
        if(t == null)
            return "";

        String result = String.valueOf(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if(!"".equals(left) && !"".equals(right)){
            left = "("+left+")";
            right = "("+right+")";
        }else if(!"".equals(left) && "".equals(right)){
            left = "("+left+")";
            right = "";
        }else if("".equals(left) && !"".equals(right)){
            left = "()";
            right = "("+right+")";
        }else{
            left = "";
            right = "";
        }

        return result+left+right;

    }

    public static void main(String[] args) {
        No606 no606 = new No606();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.print(no606.tree2str(n1));
    }
}
