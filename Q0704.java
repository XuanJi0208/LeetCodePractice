/**
 * @author XuanJi
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 简单的白给题，没太多要判断的边界条件，直接和中间比就可以了。几分钟就能写完。
 */

public class Q0704 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left =0;
        int right = length-1;
        //定义查找的左右端
        while(left<=right){
            int k = (left+right)/2;
            //找到中间位置，和中间比，如果小就去找右边，如果大就去找中间。
            if(target==nums[k]){
                return k;
            }
            else if(target<nums[k]){
                right = k - 1;
            }
            else{
                left = k +1;
            }
        }
        //while遍历完了，没有找到，说明数组里不存在target。
        return -1;

    }
}
