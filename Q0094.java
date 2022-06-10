import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
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
public class Q0094 {
    private class digui() {
        //递归思想是访问左子树→访问其本身→访问右子树
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }//第一次写忽略了判断节点为空
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    private class feidigui() {
        //非递归的主要思路是：利用一个栈，每次遍历，先把它放进栈里，
        //然后去到左子树，继续放进栈里，直到没有左子树，也即进入了空节点
        //此时，弹出栈内元素，直接res.add它，然后访问它的右子树，继续循环。
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<TreeNode> Stk = new Stack<TreeNode>();//建立栈和准备返回的res
            while (root != null || !Stk.isEmpty()) {//这里改了几次，主要要想清楚，什么时候跳出循环？
                //我们应该在遍历结束后停止循环，毫无疑问，结束时整棵树都应该被弹出，所以栈肯定要是空的
                //但显然，过程中还会有多次栈空情况，那么我们如何区分？
                //要注意的是，关键是栈空时没有下一个节点可以寻找
                //栈空一定在pop后，此时这个节点已经没有左孩子，而如果在root = root.right后，root依旧为空，也就说明它没有右孩子
                // 此时这个节点就是仅剩的节点，所以终止循环
                while (root != null) {
                    Stk.push(root);
                    root = root.left;
                }//一直去到左子树
                //此时左子树已经为空，我们希望能先弹出栈内元素
                root = Stk.pop();
                //此时弹出的这个root就是目前的最左节点，直接放进res
                res.add(root.val);
                //然后访问它的右子树
                root = root.right;
            }

            return res;
        }
    }
}