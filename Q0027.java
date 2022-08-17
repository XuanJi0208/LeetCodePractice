/**
 * @author XuanJi
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Q0027 {
    //这个end-1 是试出来的捏，没有成功一次写出来
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int end = nums.length;
        while (i < end) {
            if (nums[i] == val) {
                nums[i] = nums[end - 1];
                end--;
            } else {
                i++;
            }
        }
        return i;
    }
}
