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

        //旧题重做又写了一遍，这次对于优先动low还是优先动high理解更深了一点。做的时候主要要考虑的，是left(low)指的是哪里，right(high)指的又是哪里。
        //不管是左闭右开还是双闭，如果最后想要输出的是left，那么注意当nums[mid]和target相等的时候，一定是动right不动left，如果动了left，很可能会丢掉目标位置。
        //所以这里虽然不比较nums[k] == target在内存利用率上更好，我还是认为去比较一下，能让代码更易读，逻辑更清晰。之所以时间没有太大差异，一是可能target存在数组里的可能性不够大
        //而是这个题本身的测试用例就不够大，导致二分法后几乎都是0ms用时，看不出明显影响。
        //下面贴出左闭右开的代码。

    public int searchInsert3(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        int mid = (left + right)/2;
        //这里为了方便，稍微思虑一下区间开闭问题。首先是这题实际上不需要真的找到，只需要找到它该在的位置就行了
        //因此，如果位置落在left这边，那么左边用闭区间，其位置直接落在left就是最好的
        //如果位置往right那边落，那么要考虑，如果右侧选择闭区间，其位置也要往right后面落
        //因此直接选择开区间，让它落在right那个位置就行，循环跳出条件就是left和right相等
        while(left<right){
            mid = (left + right)/2;
            if(target>nums[mid]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    }

