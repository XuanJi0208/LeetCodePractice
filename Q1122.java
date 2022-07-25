/**
 * @author XuanJi
 * 给你两个数组，arr1 和arr2，arr2中的元素各不相同，arr2 中的每个元素都出现在arr1中。
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 */
public class Q1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int MAX = 0;
        for (int x : arr1) {
            MAX = Math.max(MAX, x);
        }
        int[] fre = new int[MAX + 1];
        for (int x : arr1) {
            fre[x]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < fre[x]; i++) {
                res[index++] = x;
            }
            fre[x] = 0;
        }
        for (int i = 0; i < fre.length; i++) {
            if (fre[i] != 0) {
                for (int j = 0; j < fre[i]; j++) {
                    res[index++] = i;
                }
                fre[i] = 0;
            }
        }
        return res;
    }
}
