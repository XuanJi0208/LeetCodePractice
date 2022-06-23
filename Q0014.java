/**
 * @author XuanJi
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 看答案发现一个优化
 * 即在我的catchTwo中，不需要记录实际的字符串，而只需要记录字符串有多长，再返回子串即可
 */
public class Q0014 {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        if (strs.length == 0) {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            res = catchTwo(res, strs[i]);
        }
        return res;
    }

    public String catchTwo(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            //这一段是抄自官方答案，我自己写的时候没有直接用while套条件，导致运行一直超时。
            index++;
        }
        return str1.substring(0, index);
    }

}
