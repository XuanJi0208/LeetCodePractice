/**
 * @author XuanJi
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 */
public class Q0283 {
    /**
     * 最开始想的是记录0的个数，但是发现这样一遍遍历会出错，代码贴在下面。
     */
    public void moveZeroesWrong(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                k++;
            }
            if (nums[i] != 0) {
                nums[i - k] = nums[i];
            }
            if (i + k >= len) {
                //已经满了，不管上面干了啥，现在都要补成0;
                nums[i] = 0;
            }
        }
    }

    /**
     * 最好想的应该是交换，但怎么交换？可以在发现0之后，将它和后面第一个不为0的数字交换，但这样好像就冲着O（n²)去了？先用这种暴力解写一下
     * <p>
     * 这个暴力解反正是一把过了，我看写的时候都没用三分钟，但是我需要优化，这玩意儿时间只打败了8%的用户，肯定是整不下去的。
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                for (int k = i; k < len; k++) {
                    if (nums[k] != 0) {
                        nums[i] = nums[k];
                        nums[k] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 在交换本身动动文章吧，与其动0，不如直接用双指针动非0，设置一个a一个b，a指当前元素，b指第一个为0的元素。
     * a找到非0后，就跟b交换，这时候，b直接往后走，就是下一个为0的位置
     *
     * 这个方法好用！时间瞬间就缩短了！
     */
    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        int b = 0;
        for (int a = 0; a < len; a++) {
            if (nums[a] != 0) {
                int temp = nums[b];
                nums[b] = nums[a];
                nums[a] = temp;
                b++;
            }
        }
    }
}
