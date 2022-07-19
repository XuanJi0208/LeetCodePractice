import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XuanJi
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Q0015 {
    //思路是：先把数组排序
    //从小到大开始遍历数组，取出一个数a，然后把这个数后面的数组和-a放入findPart
    //findPart中，如果有两个数满足相加等于-a，则add进list
    //从上到下遍历数组，如果遍历到的值大于0，跳出循环
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                return list;
            }
            findPart(nums, i, nums[i], list);
        }
        return list;
    }


    public List<List<Integer>> findPart(int[] nums, int head, int check, List list) {
        int top;
        int bottom = nums.length - 1;
        for (top = head + 1; top < nums.length; top++) {
            if (top > head + 1 && nums[top] == nums[top - 1]) {
                continue;
            }
            while (top < bottom && nums[top] + nums[bottom] > 0 - check) {
                bottom--;
            }
            if (top == bottom) {
                break;
            }
            if (nums[top] + nums[bottom] == 0 - check) {
                List<Integer> res = new ArrayList<>();
                res.add(check);
                res.add(nums[top]);
                res.add(nums[bottom]);
                list.add(res);
            }
        }
        return list;
    }
}
