package leetcode.e38;

/**
 * Created by txwyy123 on 18/8/12.
 */
public class No106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[postorder.length-1]) {
                index = i;
                break;
            }
        }

        int[] l = new int[index];
        int[] r = new int[inorder.length-1-index];
        System.arraycopy(inorder, 0, l, 0, l.length);
        System.arraycopy(inorder, index+1, r, 0, r.length);

        int[] postL = new int[l.length];
        int[] postR = new int[r.length];
        System.arraycopy(postorder, postorder.length-1-r.length, postR, 0, r.length);
        System.arraycopy(postorder, postorder.length-1-r.length-postL.length, postL, 0, postL.length);

        TreeNode left = buildTree(l, postL);
        TreeNode right = buildTree(r, postR);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args){
        No106 no106 = new No106();
        int[] post = {9,15,7,20,3};
        int[] in = {9,3,15,20,7};
        TreeNode root = no106.buildTree(in, post);
        System.out.print(root);
    }
}
