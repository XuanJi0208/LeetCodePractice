import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Q2089 {//很遗憾这是一篇错误答案，主要问题出在了sort身上
    //这个代码中，把Sort方法直接改为Arrays.sort()方法即可直接出答案
    //经过修改我终于解决了sort问题，sort主要有两个问题，第一个先前写了一个用于交换的方法swap，但它是无效的，不知道为什么这个方法影响了sort的编译
    //第二个问题是flag的判断位置写错了，写进了j循环里，会导致程序直接跳出。实际上应该把判断写进一次i循环中，即每次i循环做一次判断。
    public List<Integer> targetIndices(int[] nums, int target) {
        //代码主要分为两个部分，第一部分是排序，考虑冒泡和快排
        //第二个部分是搜索目标下标，在排序后查找比较容易。
        int l = nums.length;
        List<Integer> i = new ArrayList<>();
        Sort(nums, l);
        //排完之后，找一下目标下标~
        for (int j = 0; j < l; j++) {
            int n = 0;
            if (nums[j] == target) {
                i.add(j);
            }
        }
        return i;
    }

    public void Sort(int[] nums, int l) {//先写个冒泡玩一下
        boolean flag = false;
        for (int i = 0; i < l - 1; i++) {
            for (int j = l - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    nums[j] = 2;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }//未发生交换，冒泡已经完成
        }
    }
}
