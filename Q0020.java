import java.util.Stack;

/**
 * @author XuanJi
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Q0020 {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char pos = s.charAt(i);
            if (isLeft(pos)) {
                stk.push(pos);
            } else if (isRight(pos)) {
                if(stk.isEmpty()) {return false;}
                char left = (char) stk.pop();
                if (!match(left, pos)) {
                    return false;
                }
            }
        }
        if (!stk.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isLeft(char s) {
        return s == '(' || s == '[' || s == '{';
    }

    public boolean isRight(char s) {
        return s == ')' || s == ']' || s == '}';
    }

    public boolean match(char s1, char s2) {
        return (s1 == '(' && s2 == ')') || (s1 == '[' && s2 == ']') || (s1 == '{' && s2 == '}');
    }
}
