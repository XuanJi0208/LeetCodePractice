/**
 * @author XuanJi
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Q0098 {
    //思路必然是递归，如果左边小且右边大，置res为true
    //反之，res为FALSE，返回res&&左孩子&&右孩子
    public boolean isValidBST(TreeNode root) {
        return ifValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean ifValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return ifValidBST(node.left, lower, node.val) && ifValidBST(node.right, node.val, upper);
    }
}
