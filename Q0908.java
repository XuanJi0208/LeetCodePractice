public class Q0908 {
    public int smallestRangeI(int[] nums, int k) {
//思路是找到最大数和最小数，用最大数减掉k，最小数+k，然后求差，若差＜=0，则返回0，反之，返回其本身。
        int l = nums.length;
        int min = nums[0], max = nums[0];
        for (int i = 0; i < l; i++) {//找出最大最小值
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int store = max - k - min - k;
        if (store < 0) {
            store = 0;
        }
        return store;
    }
    //执行用时：1 ms
    //, 在所有 Java 提交中击败了99.93%的用户
    //内存消耗：42 MB, 在所有 Java 提交中击败了37.11%的用户
}
