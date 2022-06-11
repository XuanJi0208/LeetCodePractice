import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Q0404 {
    //给定二叉树的根节点 root ，返回所有左叶子之和。

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public int sumOfLeftLeaves(TreeNode root) {
        /* 这种题最后大概率跑不脱遍历 */
        //而遍历基本可以考虑递归
        //那么我们的主要思路就是遍历这棵树，而要解决的问题是，如何判断这个叶子节点是不是左叶子
        //解决的方法是在遍历的过程中，直接检查当前节点的左孩子是不是叶子节点
        int sum = 0;
        sum = inorder(root, sum);
        return sum;
    }

    private int inorder(TreeNode root, int sum) {
        if (root.left != null) {
            //如果左节点不为空，则判断它是不是叶子
            if (!isLeaf(root.left)) {
                //左孩子不为叶子结点，则继续进入左孩子探寻
                sum = inorder(root.left, sum);
            } else {
                //左孩子是叶子节点，则直接用sum记录值
                sum += root.left.val;
                System.out.println(sum);
            }
        }//看完左孩子再来看看右孩子
        if (root.right != null) {//右孩子不为空，则直接探查一下它是不是叶子节点，是叶子几点就不管了，不是叶子节点就继续探寻
            if (!isLeaf(root.right)) {
                sum = inorder(root.right, sum);
            }
        }//当左右孩子都看完了，把sum返回去。
        return sum;
    }

    private boolean isLeaf(TreeNode root) {//看一下它有没有左右孩子
        if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }
}




