public class Q1576 {
    //给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
    //注意：你 不能 修改非 '?' 字符。
    //题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
    //在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。

    public String modifyString(String s) {
        //比较容易想到的是，因为只需要和前后不同，也即最多和两个字母不同即可，则只需要准备三个字母，不需要考虑多余情况（我感觉我表达能力挺差的）
        //那么我们直接选定abc为替换方向
        char[] chars = s.toCharArray();
        char cha = 'a';
        char chb = 'b';
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '?') {
                if (i == 0) {
                    if(s.length()==1){
                        chars[i] ='a';
                    }else{
                        if (chars[i + 1] == 'a') {
                            chars[i] = 'b';
                        } else {
                            chars[i] = 'a';
                        }
                    }
                }
                else if (i == s.length() - 1) {
                    if (chars[i - 1] == 'a') {
                        chars[i] = 'b';
                    } else {
                        chars[i] = 'a';
                    }
                }
                else {
                    if (chars[i - 1] != 'a' && chars[i + 1] != 'a') {
                        chars[i] = 'a';
                    } else if (chars[i - 1] != 'b' && chars[i + 1] != 'b') {
                        chars[i] = 'b';
                    } else {
                        chars[i] = 'c';
                    }
                }
            }

        }
        return new String(chars);
    }
    //我很遗憾我写出了一坨很暴力的狗屎解法，但我懒得改了
}
