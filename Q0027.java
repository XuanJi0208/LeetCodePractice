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

    /**
     * 回头再做一次就直接出了，用的方法跟上面那个不一样，我感觉新的方法更好更容易理解。
     */
    public int removeElement2(int[] nums, int val) {
        //简单一想，数组中时刻记录删除了k个数字，如果当前数字不需要删除，则把它往前移k位，如果需要删除，就不动它，让他自己覆盖，最后把长度减个k就可以了
        int k = 0;
        int len = nums.length;
        for(int i = 0;i<len;i++){
            if(nums[i]==val){
                k++;
            }
            else{
                nums[i-k]=nums[i];
            }
        }
        return len-k;
    }
}
