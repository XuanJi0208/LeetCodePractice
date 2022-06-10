import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Q0144 {
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
    class Solution {
        private class digui {
            public List<Integer> preorderTraversal(TreeNode root) {//经典的前序遍历，主要思路类似中序遍历，分为递归和非递归两个部分
                List<Integer> res = new ArrayList<>();
                Inorder(root, res);
                return res;
            }

            public void Inorder(TreeNode root, List<Integer> res) {
                if (root == null) {
                    return;//非常遗憾，跟上次写Q0024的中序遍历一样，我这儿又出问题了，我把这句话写到PreOrderTraversal那个方法里了。
                }
                res.add(root.val);
                Inorder(root.left, res);
                Inorder(root.right);
            }
        }
    }

    private class feidigui {//虽然递归出了点小问题，但是还是要再写一个非递归。

        //分析思路：依然利用栈的思想
        //首先，从根节点开始入栈，然后将其左孩子再入栈，如此反复，直到当前节点为空，此时弹出栈，访问弹出节点的右孩子，然后继续左孩子循环
        //注意一点和中序遍历不同的地方，那就是记录节点这一步，在中序遍历中发生在节点出栈后，但在前序遍历中则是发生在节点入栈时
        //此外，类似中序遍历的，应注意循环弹出的条件
        public List<Integer> preorderTraversal(TreeNode root) {//经典的前序遍历，主要思路类似中序遍历，分为递归和非递归两个部分
            List<Integer> res = new ArrayList<>();
            Stack Stk = new Stack<>();
            while (root != null || !Stk.isEmpty()) {
                while (root != null) {
                    res.add(root.val);//入栈前加入
                    Stk.push(root);//入栈
                    root = root.left;//去找左孩子
                }//此时弹出while代表当前节点为空，弹出栈内第一个节点，去找它的右孩子
                root = (TreeNode) Stk.pop();
                root = root.right;
            }
            return res;
        }//想笑
        //根据力扣的两次报告，我发现递归和非递归在（至少是比较小的）树时，其表现相差不大。

    }
}
