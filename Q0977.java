/**
 * @author XuanJi
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class Q0977 {
    /**
     * 这题最容易想到的是用空间换时间，也就是造一个新的res数组，首先遍历数组直至找到0，然后以0为分界线，开始慢慢比较并填入新数组
     * 可惜没有一把过，主要是第一次定pos位置的时候，没有考虑到全负的情况。所以其实尽量要避免这种找到了之后直接取等然后break的思路。
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                pos++;
            }
//            if(nums[i]>=0){
//                pos = i;
//                break;
//            }
        }
        int lpos = pos - 1;
        int i = 0;
        while (lpos >= 0 && pos < len) {
            int lres = nums[lpos] * nums[lpos];
            int rres = nums[pos] * nums[pos];
            if (lres < rres) {
                res[i] = lres;
                lpos--;
                i++;
            } else {
                res[i] = rres;
                pos++;
                i++;
            }
        }
        if (lpos < 0) {
            while (i < len) {
                res[i++] = nums[pos] * nums[pos];
                pos++;
            }
        }
        if (pos == len) {
            while (i < len) {
                res[i++] = nums[lpos] * nums[lpos];
                lpos--;
            }
        }
        return res;
    }
}
