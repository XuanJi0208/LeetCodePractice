/**
 * @author XuanJi
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class R0025 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pointer = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }

            pointer = pointer.next;
        }
        while (l1 != null) {
            pointer.next = l1;
            l1 = l1.next;
            pointer = pointer.next;
        }
        while (l2 != null) {
            pointer.next = l2;
            pointer = pointer.next;
            l2 = l2.next;
        }
        return res.next;
    }
}
