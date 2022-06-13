import java.util.Arrays;
import java.util.HashMap;

public class Q0001 {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    public int[] twoSum(int[] nums, int target) {
        //在榜单上看到了，算是经典题？解决的话用O（n²）的算法是比较简单的，逐个对应就行了，现在需求想一个小于它的算法。

    }

    public int[] on2(int[] nums, int target) {//这是个O（n²）的算法
        //执行用时：50 ms, 在所有 Java 提交中击败了32.15%的用户
        //内存消耗：41.5 MB, 在所有 Java 提交中击败了55.51%的用户
        int l = nums.length;
        int res[] = new int[2];
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
    //试图在这个暴力解上进行优化，首先想的是排序，先对整个数组进行排序，然后使用首尾缩进进行查找

    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);//偷懒排个序⑧
        int[] res = new int[2];
        int head = 0;
        int tail = nums.length - 1;
        while (nums[head] + nums[tail] != target) {
            if (nums[head] + nums[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        res[0] = head;
        res[1] = tail;
        return res;
    }//发现犯了个蠢错误。。这样返回的是排序后的值，而想要的是排序前的下标
    //很无奈，这里其实想到的是在新数组里排序，然后去旧数组里找位置，但这样太麻烦了
    //想到用哈希表直接存位置，但这样的话。。
    //不如直接用哈希表做。。
    //所以这个方法我懒得完成了，试一下哈希表的方法
    //想笑捏

    //用哈希表的思路是存的时候，表的id等于它本身，然后存的直接是它的位置。
    //存完后遍历哈希表，从头开始遍历，去这个数的补数那里找一下，如果不存在就继续遍历，如果存在直接返回两个哈希表的值
    //比如说{3,1,2}，target＝4，那么存的哈希表就是：0-null,1-1，2-2,3-0；这样遍历到1，找target-1 =3，位置为0，则直接返回1,0
    //复杂度应该是2n，也就是O(n)

    public int[] twoSumComplete(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();//过程中想到一个优化方式，就是本来想先放进去再找的，现在想想不如边放边找？
        //试了一下确实不如边放边找。放了之后，找碰到的问题太多了，我需要双判一次当前哈希和下一个哈希是否都为空，还得来回找位置。
        //那边放边找
        int res[]=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])){
                res[0]=i;
                res[1]=hash.get(target-nums[i]);
                return res;
            }
            hash.put(nums[i], i);
        }
        return res;
        //执行用时：5 ms, 在所有 Java 提交中击败了48.32%的用户
        //内存消耗：42.2 MB, 在所有 Java 提交中击败了7.28%的用户
        //内存消耗变多了，估计是因为建了一张哈希表，这相当于一个用空间换时间的算法，但实际上一般不用占用一整个n的空间（虽然空间复杂度应该是S（n））
        //因为边存边找还有一个好处，是找到的时候往往不用存完整张表，一定程度上节省了内存，也加快了速度
        //所以这种边存边找还是挺实用的。

        //看了答案抓到自己一个小失误：return在存在res就可以写了写完之后极限执行可以达到1ms，可以击败99.30%的用户
    }
}
