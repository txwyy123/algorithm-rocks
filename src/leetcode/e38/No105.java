package leetcode.e38;

/**
 * Created by txwyy123 on 18/8/12.
 */
public class No105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }

        int[] l = new int[index];
        int[] r = new int[inorder.length-1-index];
        System.arraycopy(inorder, 0, l, 0, l.length);
        System.arraycopy(inorder, index+1, r, 0, r.length);

        int[] preL = new int[l.length];
        int[] preR = new int[r.length];
        System.arraycopy(preorder, 1, preL, 0, preL.length);
        System.arraycopy(preorder, 1+preL.length, preR, 0, preR.length);

        TreeNode left = buildTree(preL, l);
        TreeNode right = buildTree(preR, r);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args){
        No105 no105 = new No105();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode root = no105.buildTree(pre, in);
        System.out.print(root);
    }
}
