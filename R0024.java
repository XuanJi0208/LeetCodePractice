/**
 * @author XuanJi
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class R0024 {
    public ListNode reverseList(ListNode head) {
        while (head == null) {
            return head;
        }
        ListNode now = head;
        ListNode pre = null;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
