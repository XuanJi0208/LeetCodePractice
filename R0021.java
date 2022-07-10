/**
 * @author XuanJi
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 从未见过如此美妙的快排，为我欢呼，为我喝彩！
 */
public class R0021 {
    public int[] exchange(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (high < 0) {
            return nums;
        }
        int mid = nums[0];
        while (low < high) {
            while (low < high && isEven(nums[high])) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && !isEven(nums[low])) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = mid;
        return nums;
    }

    public boolean isEven(int i) {
        return i % 2 == 0;
    }
}
