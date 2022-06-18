/**
 * @author XuanJi
 */

public class R0017 {
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10,n) -1);
        int[] list = new int[max];
        for (int j = 1; j <= max; j++) {
            list[j - 1] = j;
        }
        return list;
    }
}
