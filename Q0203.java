/**
 * @author XuanJi
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */

public class Q0203 {
    /**
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return newHead.next;
    }
//试了比较多次一直不太成功，最后发现需要一个新头，以防旧的头结点被删除
    /**
     * 过了一年后重写了一下，发现思路没有前两年好了，这里不需要pre和p，一个p就可以搞定，速度快很多的。
     */
    public ListNode removeElements2(ListNode head, int val) {
        if ( head == null ){
            return head;
        }
        //若头结点为空，直接返回即可
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode res = pre;
        ListNode p = pre.next;
        //使用双指针遍历，当p所指元素为val时，让pre.next指向p.next，即删除p所在节点
        while ( p != null ){
            if ( p.val == val ){
                pre.next = p.next;
            }
            else{
                pre = pre.next;
            }
            p = p.next;
        }
        return res.next;
    }
}


