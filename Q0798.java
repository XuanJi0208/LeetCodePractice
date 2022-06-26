/**
 * @author XuanJi
 * 给你一个数组nums，我们可以将它按一个非负整数 k 进行轮调，这样可以使数组变为
 * [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]]
 * 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
 * 例如，数组为nums = [2,4,1,3,0]，我们按k = 2进行轮调后，它将变成[1,3,0,2,4]。这将记为 3 分，因为
 * 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 */
public class Q0798 {
    //错误答案，原因是复杂度过高导致无法处理较大数组，但这个方法在不考虑时间成本的前提下是正确的
    //比较好的答案是差分法。
    public int bestRotation(int[] nums) {
        int max = getScore(nums, 0);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int score = getScore(nums, i);
            //获取这个i对应的分数。
            if (max < score) {
                res = i;
            }
        }
        return res;
    }

    public static int getScore(int[] nums,int k){
        int[] get = new int[nums.length];
        for(int i = 0; i <nums.length; i++){
            int pos = (i+k)%(nums.length);
            get[i] = nums[pos];
        }
        return cal(get);
    }

    public static int cal(int[] nums){
        int score = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=i){
                score++;
            }
        }
        return score;
    }
}
