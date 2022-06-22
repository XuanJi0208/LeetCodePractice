/**
 * @author XuanJi
 * 罗马数字转整数
 */
public class Q0013 {
    public int romanToInt(String s) {
        int res = 0;
        int pre = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(pre < num) {
                res -= pre;
            } else {
                res += pre;
            }
            pre = num;
        }
        res += pre;
        return res;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
