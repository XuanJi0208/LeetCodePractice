import java.util.Stack;

/**
 * @author XuanJi
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class R0006 {
    public int[] reversePrint(ListNode head) {
        int[] res = new int[0];
        Stack stk = new Stack();
        while(head.next != null){
            stk.push(head.next.val);
            head = head.next;
        }
        int i = 0;
        while(!stk.isEmpty()){
            res[i] = (int) stk.pop();
            i++;
        }
        return res;
    }
}
