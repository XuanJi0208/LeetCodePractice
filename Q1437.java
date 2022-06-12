public class Q1437 {
    //给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。

    public boolean kLengthApart(int[] nums, int k) {//白给题，注意相隔k，所以要数组下标要加k+1
        //啊，并没有白给，上来就错了，如果出现{1,0，0,1,1}，因为下标已经溢出，所以会被判对
        //那换个暴力解法，记录上一个1的位置，然后每新找到一个1，就比较和上一个1的位置差
        int count = -1;
        //初始化位置为-1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (count != -1 && count + k + 1 > i) {
                    return false;
                }
                count = i;
            }
        }
        return true;
    }

}
