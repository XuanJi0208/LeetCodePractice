public class Q0908 {
    public int smallestRangeI(int[] nums, int k) {
        //给你一个整数数组 nums，和一个整数 k 。
        //在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
        //nums的分数是nums中最大和最小元素的差值。
        //在对nums 中的每个索引最多应用一次上述操作后，返回nums 的最低 分数 。

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
