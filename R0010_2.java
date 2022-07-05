/**
 * @author XuanJi
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class R0010_2 {
    public int numWays(int n) {
        if(n<=1){return 1;}
        final int MOD = 1000000007;
        int i = 0, j = 1, k = 1;
        for(int m = 1; m < n; m++){
            i = j;
            j = k;
            k = (i+k)%MOD;
        }
        return k;
    }
}
