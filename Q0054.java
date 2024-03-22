import java.util.ArrayList;
import java.util.List;

/**
 * @author XuanJi
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 这道题的想法，就是从头开始，往右一次，往下一次，往左一次，往上一次，依次循环。
 * 这里时间复杂度无论如何都得是mn，所以不纠结
 * 一次循环里绕一圈，一层一层绕，这里不用特别设置退出条件，如果四次全退了，那就直接退就可以了
 */
public class Q0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int wid = matrix[0].length;
        int high = matrix.length;
        if (matrix == null || wid == 0 || high == 0) {
            //空的，直接返回
            return res;
        }
        int right = wid-1;
        int down = high-1;
        int left = 0;
        int up = 0;
        //四个方向的边界

        while(true){
            for(int i = left;i <= right; i++){
                //从左往右走
                res.add(matrix[up][i]);
            }
            up++;
            if(down < up){
                break;
            }
            for(int i = up;i<= down;i++){
                //从上往下走
                res.add(matrix[i][right]);
            }
            right--;
            if(right< left){
                break;
            }
            for(int i = right;i>=left;i--){
                //从右往左走
                res.add(matrix[down][i]);
            }
            down -- ;
            if(down< up){
                break;
            }
            for(int i =down;i>=up;i--){
                res.add(matrix[i][left]);
                //从下往上走
            }
            left++;
            if(left>right){
                break;
            }
        }
        return res;
    }

    /**
     * 写了好几次，首先是while的跳出方法，我觉得很好，与其在while里写四个条件，不如分开放进里面。
     * 然后就是二维数组的行和列，一定要小心，最好能画图，多想想。
     * 最后就是宽度，宽度就是Matrix[0].length，这是每个里面有几个，所以是宽度，要想清楚。
     */
}
