/**
 * @author XuanJi
 *请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class R0028 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode i,TreeNode j){
        if(i==null&&j==null){
            return true;
        }
        if(i == null||j==null){
            return false;
        }
        return i.val == j.val && check(i.right,j.left) && check(j.left,i.right);
    }
}
