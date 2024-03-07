public class Q0012 {
    /**
     * @author XuanJi
     * 整数转罗马数字
     */
    //非常暴力，用时13ms，仅击败7%用户，堪称垃圾中的垃圾，中间还有部分条件一开始写错了
    //观看题解后发现，其实可以应用硬编码法，与我这个答案类似，但是使用数组，虽然编写费劲，但实际运行会快很多。
    public String intToRoman1(int num) {
        //先写个暴力解吧
        //先把每一位拆出来，一共有4种情况：小于4，等于4，小于9，等于9
        //一共四位，千，百，十，个
        String res = new String();
        int k = num/1000;
        if(k!=0){
            if(k>3){
                //大于3则不合题意，直接报错返回
                return res;
            }
            else{
                for(int i = 0;i<k;i++){
                    res = res + "M";
                }
            }
        }
        num = num % 1000;
        int b = num/100;
        if(b!=0){
            //四种情况：小于4，等于4，小于9，等于9
            if(b<4){
                for(int i = 0; i<b;i++){
                    res = res + "C";
                }
            }
            else if(b==4){
                res = res + "CD";
            }
            else if (4<b&&b<9){
                res = res + "D";
                for(int i = 5;i<b;i++){
                    res = res + "C";
                }
            }
            else{
                res = res + "CM";
            }
        }
        num = num % 100;
        int s = num/10;
        System.out.println(s);
        if(s!=0){
            //四种情况：小于4，等于4，小于9，等于9
            if(s<4){
                for(int i = 0; i<s;i++){
                    res = res + "X";
                }
            }
            else if(s==4){
                res = res + "XL";
            }
            else if (4<s&&s<9){
                res = res + "L";
                for(int i = 5;i<s;i++){
                    res = res + "X";
                }
            }
            else{
                res = res + "XC";
            }
        }
        num = num %10;
        if(num!=0){
            if(num<4){
                for(int i = 0;i<num;i++){
                    res = res + "I";
                }
            }
            else if (num==4){
                res = res + "IV";
            }
            else if (4<num&&num<9){
                res = res + "V";
                for(int i = 5;i<num;i++){
                    res = res +"I";
                }
            }
            else{
                res = res +"IX";
            }
        }
        return res;
    }
    }

/**
 * 接下来展示硬编码法，该编码只需要3ms，虽然写着费劲，但计算远快于我的暴力解，甚至还给这个类似暴力解起了好听的名字。
 */
class Solution1 {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}

/**
 * 最后，选用一个不那么硬的方法， 设类似4，5,10这种数字为标志位，寻找num的最大标志位，将其加入res，并减去这个标志位。写一下试试：
 */

    public String intToRoman3(int num) {
        //首先设置标志位数组
        int[] index = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] INDEX = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = new String();
        for(int i = 0;i<13;i++) {
            int value = index[i];
            String string = INDEX[i];
            while(num>=value) {
                res = res + string;
                num = num - value;
                if(num == 0){break;}
            }
        }
        return res;
    }

    /**
     * 这样的话时间达到4ms，预计相等或略低于硬编码，也就是说有时候看起来稍微笨一些的方法，不考虑后续维护的话，可能会比常规认为的巧方法更好用。
     */
}
