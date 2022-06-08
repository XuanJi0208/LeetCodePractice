public class Q1037 {
    public boolean isBoomerang(int[][] points) {
        //进行一个向量的叉乘
        //以point00为起点，构造朝向p1和p2的两个向量，然后检查其叉乘是否为0
        //两点式也可以，但是要注意除数不能为0，因此两点式不够适用
        int[] v1 = {points[0][0] - points[1][0], points[0][1] - points[1][1]};
        int[] v2 = {points[0][0] - points[2][0], points[0][1] - points[2][1]};
        if (v1[0] * v2[1] - v1[1] * v2[0] != 0) {
            return true;
        }
        return false;
    }//主要难度可能是在二维数组上，但是因为仅是二维的向量，所以难度比较低。

    //再考虑，为了严谨可以加上一个判断向量是否有三个
    //再做一个两点式的：
    //两点式的主要思路是：根据前两个向量写出 y = (x-x2)/（x1-x2)*(y1-y2) + y2，然后直接带入第三个向量比较就行
    //写个一行出
    public boolean isBoomerang2(int[][] points) {
        return (points[2][0] - points[1][0]) / (points[0][0] - points[1][0]) * (points[0][1] - points[1][1]) + points[1][1] != points[2][1];
    }//试了一下这个是能跑一部分的，就是可惜当x1-x2＝0，也就是有条线垂直的话，这玩意儿直接除0就弹出去了，我又想到，如果我再写一个以y1-y2为底的，应该这个方法就能用了！

    //所以我创造了isBoomerang3!
    public boolean isBoomerang3(int[][] points) {
        if (points[0][0] - points[1][0] != 0) {//类似iba2
            return (points[2][0] - points[1][0]) / (points[0][0] - points[1][0]) * (points[0][1] - points[1][1]) + points[1][1] != points[2][1];
        } else if (points[0][1] - points[1][1] != 0) {
            // x = (y-y2)/(y1-y2)*(x1-x2) +x2
            return (points[2][1] - points[1][1]) / (points[0][1] - points[1][1]) * (points[0][0] - points[1][0]) + points[1][0] != points[2][0];
        } else {
            System.out.println("有两个点是TM重的，别以为我不知道！");
            return false;
        }//然后我发现这个还是有些不行，考虑后发现是因为除法出现了精度问题！我真是日了狗了，这说明这个方法是不能使用的。。。
    }
}

