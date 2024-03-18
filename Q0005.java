/**
 * @author XuanJi
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 最好想的应该就是栈吧。但是栈更多是判断，每次都整个进栈判断的话，时间和空间成本太高。
 * 换个思路想，回文子串的开头和结尾应该是逐个对应的，可以用二维数组存储当前串是否为子串。判断时，先检查头尾是否相当，再去头尾后检查数组，就可以快速判断。
 */
public class Q0005 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        char[] CharArray = s.toCharArray();
        //如果字符串为空或只有一个字符，那么它本身就是最小回文子串，直接返回就可以了。
        int MaxLen = 1;
        //定义最大长度，如果字符串非空，则最小为1.
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
            //初始化：如果只有一个字符，那么必定是回文。
        }
        int begin = 0;
        for (int Len = 2; Len <= length; Len++) {
            /**
             * 这里最开始写错了，写成Len < length了，实际上子串长是可以和整个串等长的，这里有点惯性思维楽，没处理好。
             */
            //用Len定义子串的长度，因为我们需要逐层遍历，因此不能按左边界遍历，而是要一层层遍历，最开始的长度Len应该是2，如果是1，没必要判断，已经初始化过了，如果是0，更是毫无意义
            for (int i = 0; i < length; i++) {
                //当前子串的左边，从串头开始判断。
                int j = Len + i - 1;
                //j即为右边界
                //j - i + 1 = len，按这个算出j为len+i-1
                if (j >= length) {
                    break;
                    //如果j越界了，这次循环没意义了，跳出这个for，继续走外面那层for
                }

                if (CharArray[i] != CharArray[j]) {
                    isPalindrome[i][j] = false;
                    //如果i和j不相同，那么它肯定不是回文子串
                } else {
                    //如果相同，那么要去看它本身有没有下一层，如果两者相差太小了，只有2的话，就不用看下一层了。
                    if(j-i<3){
                        isPalindrome[i][j] =true;
                    }
                    else{
                        isPalindrome[i][j] = isPalindrome[i+1][j-1];
                    }
                }
                //判断完了，现在就要看它是不是最大的子串了。
                if(isPalindrome[i][j] && Len > MaxLen){
                    MaxLen = Len;
                    begin = i;
                    /**
                     * 这个是我自己没想到的，我当时做的是当场存子串了，实际这里记录起始位置和长度就可以，不需要直接存相应子串，不然太麻烦了。
                     */
                }
            }

        }
        return s.substring(begin,begin+MaxLen);
    }
}
