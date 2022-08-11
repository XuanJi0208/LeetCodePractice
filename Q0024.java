/**
 * @author XuanJi
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Q0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        while (pre.next != null && pre.next.next != null) {
            //只挪一个指针，不挪三个指针
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            node1.next = node2.next;
            node2.next = node1;
            pre.next = node2;
            pre = node1;
        }
        return newHead.next;
    }
}
