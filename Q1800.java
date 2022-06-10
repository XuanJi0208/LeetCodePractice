public class Q1800 {
    //给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
    //子数组是数组中的一个连续数字序列。
    //已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。

    public int maxAscendingSum(int[] nums) {
        //先设立一个max，逐个找出升序子数组，然后比较后存入max；
        int l = nums.length;
        int max = 0;
        int counter = 0;
        for (int i = 0; i < l; i++) {
            counter = counter + nums[i];//先将指针值存入counter；
            if (i == l - 1 || nums[i] >= nums[i + 1]) {//升序子数组结束，统计counter值
                if (counter >= max) {
                    max = counter;
                }
                counter = 0;
            }
        }
        return max;
//遇到的问题有两个，第一个是nums[i]和nums[i+1]的比较，忽略了最后一位，解决方法是每次if判断时检查是否最后一位，如果已经是最后一位则数组结束直接跳出。
    }
}
