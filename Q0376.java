import java.util.Arrays;

/**
 * @author XuanJi
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * <p>
 * 逻辑是这样的：用双指针pre和p，当前nums[p] - nums[pre]差值记录一下，然后pre++，然后p++直到找到下一对nums[p] - nums[pre]差值相反，给res++
 * 注意开头的情况：如果开头两个的差值是0，那么此时MAX为1，我们要先初始化，令pre和p找到那个差值不为0的数值对，否则直接返回1.
 */
public class Q0376 {
    Arrays.sort();
    public int WRONGwiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int pre = 0;
        //定义头指针，从0开始。
        int p = 1;
        //定义尾指针，从1开始；
        int cha = nums[p] - nums[pre];
        //记录差值
        int MAX = 1;
        //定义结果，从1开始
        while (cha == 0 && p < nums.length) {
            p++;
            pre++;
            cha = nums[p] - nums[pre];
        }
        //整理一下现在的情况：pre和p指到了第一对差值非0的数，或者p已经超限了，我们需要区分这种情况吗？
        if (p == nums.length - 1) {
            return 2;
        }
        MAX++;
        while (p < nums.length - 1) {
            pre = p;
            p++;
            while (p < nums.length && !xiangFan(cha, nums[p] - nums[pre])) {
                p++;
            }
            if (p == nums.length) {
                return MAX;
            }
            MAX++;
        }
        return MAX;
    }

    public boolean xiangFan(int a, int b) {
        if (a < 0 && b > 0) {
            return true;
        } else if (a > 0 && b < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 上面写的完全过不了，写的太麻烦了，导致边界那里全是乱的，居然是中等题过不去。很痛苦
     * 参照贪心算法，重新思考这道题。
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            //如果数组里只有0个或1个，整个数组一定都满足摆动，直接返回整个数组即可。
            return nums.length;
        }
        int preDiff = 0;
        //记录上一次差值
        int Diff = 0;
        //记录这一次差值
        int res = 1;
        //记录结果，默认为1，即数组里面所有的数字都是一样的。
        for (int i = 0; i < nums.length - 1; i++) {
            Diff = nums[i + 1] - nums[i];
            //计算下一个位置的差值
            if ((preDiff >= 0 && Diff < 0) || (preDiff <= 0 && Diff > 0)) {
                res++;
                preDiff = Diff;
            }
        }
        return res;
    }
}
