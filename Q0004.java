public class Q0004 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     */

    /**
     * 这道题最好想的应该是暴力解，即直接把两个数组排序，然后从排完序的列表里找到中位数，因此先写一个暴力解。
     */
    class Solution {
        public double findMedianSortedArray(int[] nums1, int[] nums2) {
            class Solution1 {
                public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                    int l1 = nums1.length;
                    int l2 = nums2.length;
                    int l = l1 + l2;
                    int[] res = new int[l];
                    int i, j, k;
                    i = j = k = 0;
                    while (i < l1 && j < l2) {
                        if (nums1[i] < nums2[j]) {
                            res[k] = nums1[i];
                            i++;
                        } else {
                            res[k] = nums2[j];
                            j++;
                        }
                        k++;
                    }
                    if (i >= l1) {
                        while (j < l2) {
                            res[k++] = nums2[j++];
                        }
                    } else if (j >= l2) {
                        while (i < l1) {
                            res[k++] = nums1[i++];
                        }
                    }
                    //此时res即为合并后的数组。
                    if (l % 2 == 1) {
                        //若为奇数
                        double mid = res[l / 2];
                        return mid;
                    } else {
                        //若为偶数
                        double mid = res[l / 2] + res[l / 2 - 1];
                        return mid / 2;
                    }
                }
            }
        }

        /**
         * 这个做法的用时其实比较短，1ms击败100%用户，但内存44M，仅击败37.25%。
         * <p>
         * 接下来则是考虑优化代码，转换思考方式：与其思考谁是中位数，不如思考谁不是中位数。找出两个数组的中位数进行比较，对于较小的一方来说，那个数组里比他小的数一定不是中位数
         * 同理，对面的大数也可以通过这个排除一半数组。但是这个方法的问题在于，从第二次开始，这个方法就已经不适用了。
         * 上面的整段垮掉。
         * <p>
         * 转换思考方式：还是思考谁是中位数，两数组共有l个数字，如果l为奇数，则是共有2k+1个数字，找第k+1个；如果为偶数，则是2k个，找第k和第k+1。
         * 第一次想找第k个数字，先找第k/2个位置，小的那方，则连它自己一起从数组中除掉，则这样除掉了a个数字，下一次找的数就是第k-a大的数，这样一直减到1.
         * 此时两个数字中较小的数字就是第k个，把它也去掉，剩下两个数组开头，谁小谁是k+1.
         * 试一下
         * <p>
         * 写了两次都没写对，主要问题是每次要定义的量太多了，每个都要考虑越界问题，老跑出问题
         * 加起来写了一个多小时，肯定是不行了，其实第二次想到用递归了，但是没坚定下去，主要是递归在java里不太会写
         * 这次按着答案的思路写一下递归
         * 同时，答案中有一个思想很好。我也想把奇偶的情况合在一起处理，但我更关注于找到，答案则是选择把奇数的位置输出两次，显然强于我的想法。
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            int l = l1 + l2;
            int left = (l + 1) / 2;
            int right = (l + 2) / 2;
            //这里定下来找的是left和right两个数字，如果是奇数个，那么left和right是相等的。
            return (getKth(nums1, nums2, 0, l1 - 1, 0, l2 - 1, left) + getKth(nums1, nums2, 0, l1 - 1, 0, l2 - 1, right)) / 2;
        }

        //写函数，找第K个数
        private double getKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //定义一下剩余长度
            //如果这时候考虑谁空了，还需要挨个比较，不如直接让nums1始终为最小的，这样就省掉好多条件。
            if(len1>len2){
                return getKth(nums2,nums1,start2,end2,start1,end1,k);
            }
            //这样len1肯定最小，如果它空了，就返回nums2里的第k个数就行了
            if(len1==0){
                return nums2[start2+k-1];
            }
            /**
             * 下面这个第一次跑的时候漏掉了，就是k==1的时候，很多事在下次循环里会很麻烦，所以这次就解决掉。
             */
            if(k==1){
                return Math.min(nums1[start1],nums2[start2]);
            }
            //现在没人空了，那么就比较，先定义位置，顺便卡一下不要让比较位置越界
            int i = start1 + Math.min(len1,k/2)-1;
            int j = start2 + Math.min(len2,k/2)-1;

            //比较位置就可以了
            //如果nums1里面的比较小，就需要去掉里面的数字，也就是把开头设到i的后一位，结尾不要动，此时数组里失去了i-start1+1个数字
            if(nums1[i]<nums2[j]){
                return getKth(nums1,nums2,i+1,end1,start2,end2,k-i+start1-1);
            }else{
                return getKth(nums1,nums2,start1,end1,j+1,end2,k-j+start2-1);
            }
        }
    }
}
