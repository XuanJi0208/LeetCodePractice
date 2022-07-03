import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author XuanJi
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class R0007 {
    //error答案：显示StackOverFlowError,可能是因为局部变量过多
    private HashMap<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = inorder.length;
        for (int i = 0; i < l; i++) {
            pos.put(inorder[i], i);
        }
        TreeNode root = findRootNode(preorder, inorder, 0, l - 1, 0, l - 1);
        return root;
    }

    public TreeNode findRootNode(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root = preorder_left;
        //找到前序遍历里根的位置
        int inorder_root = pos.get(preorder[preorder_root]);
        //找到中序遍历里根的位置
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //建立当前根节点
        1, 2, 3 4 5, 6
        int numOfLeft = inorder_root - inorder_left;
        int numOfRight = inorder_right - inorder_root;
        //找到左右子树的节点个数
        int subLeft_preorder_left = preorder_left++;
        //前序遍历中，左子树的起始点是当前根的下一个节点
        int subLeft_preorder_right = subLeft_preorder_left + numOfLeft - 1;
        //前序遍历中，左子树的结尾点是起始点加上左子树的节点数
        int subRight_preorder_left = subLeft_preorder_right++;
        //前序遍历中，右子树的起点是左子树结尾点的下一个节点
        int subRight_preorder_right = subRight_preorder_left + numOfLeft - 1;
        //前序遍历中，右子树终点是起始点加右子树节点数
        int subLeft_inorder_left = inorder_left;
        //中序遍历中，左子树的起始点仍然是原区间的起始点
        int subLeft_inorder_right = inorder_root--;
        //中序遍历中，左子树的结尾是原根的左侧节点
        int subRight_inorder_left = inorder_root++;
        //中序遍历中，右子树的开头是原根的右侧节点
        int subRight_inorder_right = inorder_right;
        //中序遍历中，右子树的结尾是原区间的结尾


        root.left = findRootNode(preorder, inorder, preorder_left++, preorder_left + numOfLeft, inorder_left, inorder_root--);
        root.right = findRootNode(preorder, inorder, preorder_left + numOfLeft + 1, preorder_left + numOfLeft + numOfLeft, inorder_root++, inorder_right);
        //递归建立左右孩子

        return root;

    }


    //正确答案：
    private HashMap<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = inorder.length;
        for (int i = 0; i < l; i++) {
            pos.put(inorder[i], i);
        }
        TreeNode root = findRootNode(preorder, inorder, 0, l - 1, 0, l - 1);
        return root;
    }

    public TreeNode findRootNode(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = pos.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = findRootNode(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = findRootNode(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}



