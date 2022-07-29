/**
 * @author XuanJi
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Q0101 {
    /**
     * 在这道题里明确一下递归的写法，递归的根本写法是拆解问题
     * 问题是判断是否对称，我们想到，如果根为空，则一定对称，否则，检查左右孩子，这里是主函数内容
     * 那么检查左右子树显然用递归完成，如何检查左右子树？
     * 首先，判断两个节点是不是对称
     * 然后再继续检查，此时需要检查(left.left,right.right)和(left.right,right.left）
     * 接着，这个问题被拆解成了两组子树的对比，由此进入递归
     * 所以我觉得递归要想提前全部想好是很难的，不如先动手写一下，逐个解决问题即可。
     */
    public boolean isSymmetric(TreeNode root) {
        //思路依然是递归，先写写看
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        } else if ((left != null && right != null) && (left.val == right.val)) {
//            return check(left.left, right.right) && check(left.right, right.left);
//        } else {
//            return false;
//        }
        /*
        注释注释掉的这部分是我原本的写法
        实际上可以优化为：
        ①先判断 左右是否都空
        ②然后判断 左右是否有空，因为①判断后，不会出现双双空的情况，所以只要有一个空着就说明另一个不空，返回false
        ③前面两次判断后，若走到这里，则都非空，那么比较两者的值，如果不同，返回false
        ④现在已经确定了两者符合对称条件，接下来返回两者孩子即可
         */
        //新写出来的判断：
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
