import java.util.Arrays;

/**
 * @author XuanJi
 * <p>
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 这个题比较简单的想法，其实应该是排序。我把两个数组按顺序排起来，然后从头开始遍历胃口函数，去饼干函数里找第一个能满足它的饼干，如果没有，当场返回即可。如果找到了，两个指针一起后挪。
 * 时间复杂度是排序复杂度加上遍历两个数组，这里使用JAVA里自带的sort。
 */
public class Q0455 {
    public int findContentChildren1(int[] g, int[] s) {
        int res = 0;
        //记录能满足的孩子数量，从0开始。
        if (g.length == 0 || s.length == 0) {
            //如果饼干或孩子有一项数量为0
            return res;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        //将g和s排序，这里使用Arrays.sort()方法。
        int sPoint = 0;
        //设立用于饼干s数组的指针。
        for (int i = 0; i < g.length; i++) {
            //遍历胃口数组，从0开始，遍历到0
            while (sPoint < s.length && g[i] > s[sPoint]) {
                sPoint++;
                //如果孩子胃口大于饼干，则一直往后寻找。
            }
            if (sPoint >= s.length) {
                //如果饼干已经遍历完了，直接返回结果
                return res;
            }
            //如果当前饼干吃的下去，则吃下饼干（res++），然后继续寻找（sPoint++，进入下次for循环）
            res++;
            sPoint++;
        }
        return res;
    }

    /**
     * 优化一下，让代码更清晰一点
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //先对两个数组进行排序
        int i = 0;
        int j = 0;
        //设定双指针，i指向孩子数组，j指向饼干数组
        while ( i < g.length && j < s.length ){
            if ( g[i] <= s[j] ){
                //如果可以满足，孩子往后走
                i++;
            }
            j++;
            //不满足，继续找下一块饼干；满足，这块饼干分配过了，继续找下一块饼干。同意来说，饼干指针都往后走。
        }
        return i;
    }
}
