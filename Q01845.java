import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author XuanJi
 * 请你设计一个管理 n个座位预约的系统，座位编号从1到n。
 *
 * 请你实现SeatManager类：
 *
 * SeatManager(int n)初始化一个SeatManager对象，它管理从 1到 n编号的n个座位。所有座位初始都是可预约的。
 * int reserve()返回可以预约座位的最小编号，此座位变为不可预约。
 * void unreserve(int seatNumber)将给定编号seatNumber对应的座位变成可以预约。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/seat-reservation-manager
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01845 {
    class SeatManager {
        private PriorityQueue<Integer> SeatQueue;

        public SeatManager(int n) {
            SeatQueue = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                SeatQueue.add(i);
                //用1代表可以预定
            }
        }

        public int reserve() {
            return SeatQueue.remove();
        }

        public void unreserve(int seatNumber) {
            SeatQueue.add(seatNumber);
        }
    }
}
