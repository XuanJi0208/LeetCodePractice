import java.util.ArrayList;
import java.util.List;

/**
 * @author XuanJi
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 思路很简单：就是一个前序遍历即可，没有太多可以注意的点。维护一个String字符串，当碰到非空节点，把箭头和该结点的值加到字符串里，如果这是叶子结点，就直接add到list里面，否则，继续遍历左右孩子。
 */
public class Q0257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    public void dfs(TreeNode root, String path, List res) {
        //思考一下，这里总共有三种情况：首先，root为空，直接返回
        //其次，root为叶子节点，直接给path里面加上这个节点的值，然后返回
        //再次，root为非叶子节点，给path里加上这个节点的值和箭头，然后哪边有孩子去哪边（也可以都去，少一次判断条件）
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        dfs(root.left, path + "->", res);
        dfs(root.right, path + "->", res);
    }

    /**
     * 这道题看官答，用toString（不确定原因是不是这个）似乎更快一点。
     */
}
