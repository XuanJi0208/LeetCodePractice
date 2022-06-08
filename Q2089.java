import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Q2089 {//很遗憾这是一篇错误答案，主要原因可能是sort方法调用失败
                    //这个代码中，把Sort方法直接改为Arrays.sort()方法即可直接出答案
    public List<Integer> targetIndices(int[] nums, int target) {
        //代码主要分为两个部分，第一部分是排序，考虑冒泡和快排
        //第二个部分是搜索目标下标，在排序后查找比较容易。
        int l = nums.length;
        List<Integer> i = new ArrayList<>();
        Sort(nums,l);
        //排完之后，找一下目标下标~
        for(int j = 0;j<l;j++){
            int n = 0;
            if(nums[j]==target){
                i.add(j);
            }
        }
    return i;
        }

        public void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
            return;
        }//写个交换函数给冒泡和快排用
    public void Sort(int[]nums, int l){//先写个冒泡玩一下
        boolean flag = false;
        for(int i = 0;i < l-1;i++){
            for(int j = l-1; j > i;j--){
                if(nums[j]<nums[j-1]){
                    swap(nums[j],nums[j-1]);
                    flag = true;
                }
                if(!flag){
                    return;
                }//未发生交换，冒泡已经完成
            }
        }
    }
    }
