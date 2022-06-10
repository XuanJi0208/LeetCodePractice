public class Q1365 {

    //给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
    //换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
    //以数组形式返回答案。

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        for (int i = 0; i <= l; i++) {
            int counter = 0;
            for (int j = 0; j <= l; j++) {
                if (nums[i] > nums[j]) {
                    counter++;
                }
            }
            result[i] = counter;
        }
        return result;
    }
}
