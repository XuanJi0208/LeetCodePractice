import java.util.HashMap;

/**
 * @author Xuanji
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class R0003 {
    public int findRepeatNumber(int[] nums) {
        int l = nums.length;
        HashMap<Integer, Boolean> hashMap = new HashMap<>(l);
        for (int i = 0; i < l; i++) {
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(nums[i], true);
            } else {
                return nums[i];
            }

        }
        return 0;
    }
}
