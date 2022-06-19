/**
 * @author XuanJi
 */
public class L0017 {
    public int calculate(String s) {
        int x = 0;
        int y = 1;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;
            } else if (c == 'B') {
                y = 2 * y + x;
            }
        }
        return x+y;
    }
}
