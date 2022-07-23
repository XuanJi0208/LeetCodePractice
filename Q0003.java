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
