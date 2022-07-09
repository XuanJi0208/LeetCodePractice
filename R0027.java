/**
 * @author XuanJi
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class R0027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            exchange(root);
        }
        return root;
    }

    public void exchange(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        exchange(root.left);
        exchange(root.right);
    }
}
