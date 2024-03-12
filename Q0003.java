import java.util.HashSet;

/**
 * @author XuanJi
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Q0003 {
    //先前写复杂的原因主要是因为没有设计好指针位置
    public int lengthOfLongestSubstring(String s) {
        HashSet check = new HashSet<>();
        int right = -1;
        int MAX = 0;
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                check.remove(s.charAt(left - 1));
            }
            while (right + 1 < s.length() && !check.contains(s.charAt(right + 1))) {
                check.add(s.charAt(right + 1));
                right++;
            }
            MAX = Math.max(MAX, right - left + 1);
        }
        return MAX;
    }
}

/**
 * 第二次重写的方法，和上面那个其实类似的，但是感觉下面这个low一点，好理解一点
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //基础思路是双指针head和tail，head是子串开头，tail是子串尾。
        //tail碰到的每一个字符，先比较HashSet里是否存在，若不存在，继续后走
        //若已经存在，先把当前的size存起来，然后把head指的元素remove掉，tail不动，再次比较。
        //写的时候要思考的问题：head有没有可能跑到tail后面？
        HashSet hs = new HashSet<>();
        int res = 0;
        int head = 0;
        int tail = 0;
        int l = s.length();
        while(tail<l){
            if(hs.contains(s.charAt(tail))){
                //如果已经存在tail元素，说明子串重复，存当前size，head指针往后走，tail不动
                res = Math.max(hs.size(),res);
                hs.remove(s.charAt(head));
                head++;
            }else{
                //不存在tail元素，把tail元素加进去,tail往后走
                hs.add(s.charAt(tail));
                tail++;
            }
            //猜想得知，当head和tail重合的时候，tail所指元素是不进入哈希的，所以此时哈希为空，head不会继续跑。
        }
        //唯一注意一个问题：保存的res是最大值么？不一定，如果while循环结束，最后这一组串最大，此时没存res，因此return值需要一个比较
        return Math.max(res, tail - head);
    }