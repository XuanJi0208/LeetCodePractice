/**
 * @author XuanJi
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 */
public class R0015 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int check = Math.abs(n);
            int res = 0;
            for(int i = 0; i < 32; i++){
                if((n&(1<<i))!=0){
                    res++;
                }
            }
            return res;
        }
    }
}
