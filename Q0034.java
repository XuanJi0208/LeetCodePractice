/**
 * @author XuanJi
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 都要求O(log n)了，那就是用二分法解决问题。
 * 这题最根本的，是要用两个指针，依次寻找target的左起始点和右起始点。
 * 找左起始点就是找target左边的第一个元素，也就是不管目前二分找的是不是target：如果mid比target小，左端点就是在右边，去右边找；如果比target大，就是在左边，往左边找；如果等于target，还是在左边，往左边找
 * 左右各一次，就是o（log n）
 */
public class Q0034 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int lRes = -1;
        int rRes = -1;
        //定义好左右端点
        if(len ==0){
            return new int[]{lRes,rRes};
        }
        int left = 0;
        int right = len-1;
        int mid;
        //找两边端点用的left、right和mid
        while(left<=right) {
            //找左端点用双闭区间，跳出循环时right在left左一个，这时候right指的是第一个target
            mid = (left+right)/2;
            if(target > nums[mid]){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if(left>=len||nums[left]!=target){
            //此时left指的应该是第一个target，如果这时候指的不是target自己，那么说明target不存在，直接跳出去就行
            return new int[]{lRes, rRes};
        }

        lRes =left;
        //target存在，左开端已在阵中。

        //这个时候就要考虑找右开端了，逻辑其实还是类似的，不过数组左端点直接从之前的left开始就可以了，稍微重置一下right的数值。
        right = len-1 ;
        //这里考虑右结尾，首先因为left打到左开端了，所以根本不会碰到比target小的数，如果相等，要找的右开端还在右侧，把left动过去，如果打了，说明右开端在左侧，动一下right
        //双闭，跟上面同理，指的还是right
        while(left<=right){
            mid = (left+right)/2;
            System.out.println("Mid"+mid+"left"+left+"right"+right);
            if(target==nums[mid]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        rRes = right;
        return new int[]{lRes, rRes};
    }

    /**
     * 用了很差劲的方法来回试验来回改，主要问题有这么几个：
     * 首先，left、right和目标位置找错了，这个最好多想想，甚至举个例子拿笔写写，一般就不会错了
     * 其次，if(left>=len||nums[left]!=target)这里，一定不要忘了考虑left会不会越界的问题，也就是当target不存在的时候，这里会不会越界，一定要考虑到。
     * 再次，大于小于号别写错了
     *
     *
     * 我的方法太普通了，看一下标答的方法。
     * 标答的第一个方法和我的类似，但是因为找两边的这个工作实际上比较重复，考虑直接写一个function用两遍，速度会快很多
     */

    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 这个方法折磨的是也有一堆边界条件，但是确实比我那个简单，面试的时候我可能还是愿意写我自己那个，虽然不够优秀，但是容错率高一点。
     */
}
