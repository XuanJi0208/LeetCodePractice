import java.util.HashMap;

/**
 * @author XuanJi
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class R0057 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int l = nums.length;
        for(int i = 0; i <l ; i++){
            if(numsMap.containsKey(target-nums[i])){
                res[0] = target-nums[i];
                res[1] = nums[i];
                break;
            }
            numsMap.put(nums[i],1);
        }
        return res;
    }
}
