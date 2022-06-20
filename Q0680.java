/**
 * @author XuanJi
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class Q0680 {
    public boolean validPalindrome(String s) {
        //最终思路为如果两侧不相等，只在当前位置判断一次
        //额外创建一个函数用于分别判断删除两边元素，子串是否相等即可。
        int l = s.length();
        int change = 0;
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            char c1 = s.charAt(head);
            char c2 = s.charAt(tail);
            if (c1 == c2) {
                head++;
                tail--;
            }
            if (c1 != c2) {
                return tryMatch(s, head + 1, tail) || tryMatch(s, head, tail - 1);
            }
        }
        return true;
    }

    public boolean tryMatch(String s, int head, int tail) {
        while (head < tail) {
            char c1 = s.charAt(head);
            char c2 = s.charAt(tail);
            if (c1 != c2) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
