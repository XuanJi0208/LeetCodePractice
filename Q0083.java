/**
 * @author XuanJi
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */
public class Q0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            if (pre.val == p.val) {
                pre.next = p.next;
                p = p.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }
        return head;
    }
}
