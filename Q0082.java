/**
 * @author XuanJi
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class Q0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prepre = newHead;
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val == pre.val) {
                while (p != null && p.val == pre.val) {
                    p = p.next;
                }
                pre = p;
                prepre.next = pre;
                if (p != null) {
                    p = p.next;
                }
            } else {
                prepre = prepre.next;
                pre = pre.next;
                p = p.next;
            }
        }
        return newHead.next;
    }
}
