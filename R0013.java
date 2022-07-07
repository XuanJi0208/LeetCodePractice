/**
 * @author XuanJi
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 */
public class R0013 {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        if (k == 0) {
            return 1;
        }
        boolean record[][] = new boolean[m][n];
        record[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ifEnterable(i, j, k)) {
                    if (i - 1 > -1) {
                        record[i][j] |= record[i - 1][j];
                    }
                    if (j - 1 > -1) {
                        record[i][j] |= record[i][j - 1];
                    }
                }
                res += record[i][j] ? 1 : 0;
                System.out.println("i"+i+"j"+j+"if"+record[i][j]);
            }
        }
        return res;
    }

    public boolean ifEnterable(int i, int j, int k) {
        return i % 10 + i / 10 + j % 10 + j / 10 <= k;
    }
}
