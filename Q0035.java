public class Q0035 {
    //Q:给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //请必须使用时间复杂度为 O(log n) 的算法。

    //首先考虑折半查找
    public int searchInsert(int[] nums, int target) {
        int l = nums.length;
        int low = 0;
        int high = l;
        int k;
        while (high > low) {
            k = (low + high) / 2;
            if (nums[k] == target) {
                return k;
            } else if (nums[k] < target) {
                low = k + 1;
            } else if (nums[k] > target) {
                high = k - 1;
            }
        }
        return low;
    }
    //第一次犯了两个错误，第一个是while里写的是》而不是》=。没啥可说的
    //第二个错是high初始应该＝l-1
    //解决后，注意一个写法的升级问题，也即不需要判断nums[k] == target

        public int searchInsert2(int[] nums, int target) {
        //升级完成，大约节省了1M的内存~
            int l = nums.length;
            int low = 0;
            int high = l - 1;
            int k;
            while (high >= low) {
                k = (low + high) / 2;
                if (nums[k] < target) {
                    low = k + 1;
                } else {
                    high = k - 1;
                }
            }
            return low;
        }
    }

