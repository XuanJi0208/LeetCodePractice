/**
 * @author XuanJi
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Q0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    /**
     * 两年过去了，重新写一次，这下精简了一些
     */
    public ListNode reverseList2(ListNode head) {
        ListNode res = new ListNode();
        ListNode p = new ListNode();
        while ( head != null){
            p = head.next;
            head.next = res.next;
            res.next = head;
            head = p;
        }
        return res.next;
    }
}
