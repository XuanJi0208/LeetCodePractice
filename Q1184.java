/**
 * @author XuanJi
 * 环形公交路线上有n个站，按次序从0到n - 1进行编号。我们已知每一对相邻公交站之间的距离，distance[i]表示编号为i的车站和编号为(i + 1) % n的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点start到目的地destination之间的最短距离。
 */
public class Q1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //先计算整条道路加起来的和
        int sum = sum(distance, 0, distance.length);
        //让小的那一方作为start
        int mightRes = sum(distance, Math.min(start, destination), Math.max(start, destination));
        return Math.min(mightRes, sum - mightRes);
    }

    public int sum(int[] nums, int start, int end) {
        int sum1 = 0;
        for (int i = start; i < end; i++) {
            sum1 += nums[i];
        }
        return sum1;
    }
}
