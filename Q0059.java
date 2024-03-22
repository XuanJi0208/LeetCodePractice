/**
 * @author XuanJi
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 拿个int记录当前要填的数。这里考虑一下逐层添加还是按臂添加。
 * <p>
 * 逐层添加
 *
 * 这题的难度其实出在中间那个数了，琢磨了一个小时没弄出来。
 * 整体写的还是太复杂了可能，不需要那么复杂
 */
public class Q0059 {
    public int[][] WrongGenerateMatrix(int n) {
        int res[][] = new int[n][n];
        int index = 1;
        if (n < 1) {
            //如果n不合规，直接return空的数组。
            return res;
        }
        /**
         * 因为是正方形，所以不需要考虑四个边界，只需要考虑水平、垂直的边界和圈数。
         * 每次的遍历，都是左闭右开，这样在单圈遍历过程中，就不需要考虑边界，只需要考虑index是不是大了。
         */
        int max = n - 1;
        //水平边界
        int step = 0;


        while (index > n * n) {
            for (int i = step; i < max - step; i++) {
                res[step][i] = index++;
                //从左到右
            }
            if(index>n *n){break;}
            for (int i = step; i < max - step; i++) {
                res[i][max] = index++;
                //从上到下
            }
            if(index>n *n){break;}
            for (int i = max - step; i > step;i--){
                res[max][i]= index++;
                //从右到左
            }
            if(index>n *n){break;}
            for(int i = max -step;i>step;i--){
                res[i][step]= index++;
                //从下到上
            }
        }
        return res;
    }

    /**
     *上面那个问题太多了，但整体思路是好的，不过不用这么麻烦。
     * 只要两个for循环就能解决问题。
     */
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int index = 1;
        if (n < 1) {
            //如果n不合规，直接return空的数组。
            return res;
        }
        //首先确定几圈：一共是n/2圈，这里注意，如果是奇数，其实少了最中间的数字，记得要补上
        for(int i = 0; i< n/2;i++){
            for(int j = i; j<n-i-1;j++){
                //从左上到右上
                res[i][j]=index++;
            }
            for(int j = i;j<n-i-1;j++){
                //从右上到右下
                res[j][n-i-1]=index++;
            }
            for(int j = n-i-1;j>i;j--){
                //从右下到左下
                res[n-i-1][j] = index++;
            }
            for(int j = n-i-1;j>i;j--){
                //从左下到左上
                res[j][i] = index++;
            }
        }
        if(n%2==1){
            res[n/2][n/2]=index;
        }
        return res;
    }
    /**
     * 这样写简洁了很多，主要是原来的step和max，因为一开始没想清楚，后面乱掉后就全乱了。
     */
}
