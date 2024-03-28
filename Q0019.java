/**
 * @author XuanJi
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Q0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //很经典的题，经典到上了408
        //基本思路是双指针，先进行指针的初始化，让后指针在前指针的后n位。
        //接着同时移动前后两个指针，后指针的next域为空时，前指针就是倒数第n个节点，另外存储一个del指针来记录前指针的前一个节点。
        //这个地方还有一个思路，就是前指针去记录倒数第n+1个节点，这样就省去了一个指针。
        ListNode pre = new ListNode();
        ListNode p = new ListNode();
        //定义前指针和后指针
        p.next = head;
        ListNode newHead = p;
        pre = p;
        //为了方便，从head的前一位开始遍历，这样就不用单独处理head为空的情况
        for ( int i = 0; i < n; i++ ){
            if( p.next == null ){
                System.out.println("error，auto return head");
                return null;
            }
            p = p.next;
        }
        while ( p.next != null ) {
            p=p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return newHead.next;
    }
    /**
     * 失误的点有两个：
     * 第一个是p和pre的位置乱了，最好还是画图或者至少用手比划比划，感觉自己还是不够清晰
     * 第二个是newHead问题，主要处理的需要从第一个节点删除的问题：为啥要用newhead？因为head可能已经被删掉，但偏偏没准备newhead去记录，导致返回了删掉的一串节点。
     */
}
