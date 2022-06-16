/**
 * @author XuanJi
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Q0088 {
    //想到两种方法，第一种是做个新数组，然后复制进nums1
    //第二种是倒着排
    //时间复杂度都是O(m+n）
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //第一种
        int[] sort = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i == m) {
                sort[k] = nums2[j];
                j++;
            } else if (j == n) {
                sort[k] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                sort[k] = nums1[i];
                i++;
            } else {
                ;
                sort[k] = nums2[j];
                j++;
            }
            k++;
        }
        for (int l = 0; l < m + n; l++) {
            nums1[l] = sort[l];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //第二种
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i > -1 || j > -1) {
            if (i == -1) {
                nums1[k] = nums2[j];
                j--;
                System.out.println(i);
            } else if (j == -1) {
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
