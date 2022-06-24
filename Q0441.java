/**
 * @author XuanJi
 * 你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 */
public class Q0441 {
    public int arrangeCoins(int n) {
        long low = 1;
        long high = n;
        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (mid * (mid + 1) / 2 <= n) {
//                这个地方曾有一个bug，如果把判断条件写成mid * （mid + high + 1 ） <= 2*n，会在部分数据报错，目测是因为n*2后溢出。
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }
}
