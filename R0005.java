/**
 * @author XuanJi
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class R0005 {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        if (length == 0) {
            return s;
        }
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
