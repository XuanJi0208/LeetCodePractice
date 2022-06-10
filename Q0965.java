import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Q0965 {
    //如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
    //只有给定的树是单值二叉树时，才返回 true；否则返回 false。

    //主要思路可以是遍历？
    //唯一区别是遍历后不用记录节点值，而是直接比较，如果相同则继续，如果不同则直接跳出
    //先写个前序遍历！

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public boolean isUnivalTreeDIGUI(TreeNode root) {//先写个递归
            int k = root.val;
            return inorder(root,k);
        }
        public boolean inorder(TreeNode root, int k){
            if(root == null){
                return true;
            }
            else if(root.val != k){
                return false;
            }else{
                return inorder(root.left,k) && inorder(root.right,k);
            }//递归搞定了捏
        }

    public boolean isUnivalTreeFEIDIGUI(TreeNode root) {//再写个非递归
            int k = root.val;
        Stack stk = new Stack<>();
        while(root!=null||!stk.isEmpty()){
            while(root!=null){
                if(root.val != k){
                    return false;
                }
                stk.push(root);
                root = root.left;
            }
            root = (TreeNode) stk.pop();
        }
        return true;
    }//超时了我估计用不了。。可能大体上是对的？
}
