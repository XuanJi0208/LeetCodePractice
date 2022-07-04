import java.util.Stack;

/**
 * @author
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 */
public class R0009 {
    class CQueue {
        Stack stk1 = new Stack<>();
        Stack stk2 = new Stack<>();
        //新建进队栈为stk1，出队栈为stk2；
        public CQueue() {

        }

        public void appendTail(int value) {
            stk1.push(value);
        }

        public int deleteHead() {
            if(stk2.isEmpty()){
                //如果出队栈为空
                if(stk1.isEmpty()){
                    return -1;
                }
                //如果进队栈也为空，说明队列里实际没有元素，返回-1
                while(!stk1.isEmpty()){
                    //若进队栈不为空，则将进队栈的元素转移至出队栈
                    stk2.push(stk1.pop());
                }
                //转移完成
            }
            return (int) stk2.pop();
        }
    }
}
//为数不多的一遍过！哭辣！
