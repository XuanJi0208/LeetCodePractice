/**
 * @author XuanJi
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 */
public class R0018 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                return head;
            }
            p = p.next;
            pre = pre.next;
        }
        return head;
    }
}
