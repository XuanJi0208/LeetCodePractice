import java.util.HashSet;

/**
 * @author XuanJi
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class R0048 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> occ = new HashSet<>();
        int pointer = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (pointer < l && !occ.contains(s.charAt(pointer))) {
                occ.add(s.charAt(pointer));
                pointer++;
            }
            max = Math.max(max,pointer - i);
        }
        return max;
    }
}
//思想是滑动窗口，因为匹配到第k个若重复，说明去掉第一个，剩下的k-1个必定不重复，此时直接左指针++，右指针从始至终不后退
