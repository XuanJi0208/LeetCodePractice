public class Q1365 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int l = nums.length;
            int []result = new int [l];
            for(int i = 0;i <= l;i++){
                int counter = 0;
                for(int j = 0;j <= l;j++){
                    if (nums[i] > nums[j]){
                        counter++;
                    }
                }
                result[i] = counter;
            }
            return result;
        }
}
