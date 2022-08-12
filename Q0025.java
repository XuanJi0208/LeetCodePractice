/**
 * @author XuanJi
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Q0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = newHead;
        while (p.next != null) {
            for (int i = 0; i < k && p != null; i++) {
                p = p.next;
            }
            if (p == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = p.next;
            p.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            p = pre;
        }
        return newHead.next;
    }

    public ListNode reverseList(ListNode head) {
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
}
