import java.util.Stack;

/**
 * @author XuanJi
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class Q0735_看错题了 {
    //新建一个栈
    // 如果栈空，数组元素放进栈中
    // 如果栈不空，比较数组元素和栈内符号是否相同
    // 如果相同则进栈
    // 如果不相同则不用管了（已经出栈且数组指针后移）
    // 最后栈内即是新数组的元素，直接找个新数组放进去即可
    public int[] asteroidCollision(int[] asteroids) {
        Stack stk = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            if (stk.isEmpty()) {
                stk.push(asteroids[i]);
                i++;
            } else {
                int check = (int) stk.pop();
                if (!isBroken(check, asteroids[i])) {
                    stk.push(check);
                    stk.push(asteroids[i]);
                    i++;
                } else {
                    //如果相撞，则把两者中的大数存进数组，i指针不变
                    if (Math.abs(check) > Math.abs(asteroids[i])) {
                        asteroids[i] = check;
                    } else if (Math.abs(check) == Math.abs(asteroids[i])) {
                        i++;
                    }
                }
            }
        }
        int size = stk.size();
        int[] res = new int[size];
        for (int j = size - 1; j > -1; j--) {
            res[j] = (int) stk.pop();
        }
        return res;
    }

    public boolean isBroken(int i, int j) {
        if ((i > 0 && j > 0) || (i < 0 && j < 0)) {
            return false;
        }
        return true;
    }
}
