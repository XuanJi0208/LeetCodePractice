/**
 * @author XuanJi
 */

public class R0017 {
    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = max * 10;
        }
        int[] list = new int[max - 1];
        for (int j = 1; j < max; j++) {
            list[j - 1] = j;
        }
        return list;
    }
}
