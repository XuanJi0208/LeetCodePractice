import javax.swing.tree.TreeNode;

/**
 * @author XuanJi
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class R0055 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(getHeight(root.left) - getHeight(root.right)>1)){
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
//里面的几乎每一句话都是一次bug，都快改吐了