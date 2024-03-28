/**
 * @author XuanJi
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 不允许修改 链表。
 */
public class Q0142 {
    /**
     * 408见过的题。印象中应该是快慢指针？思考一下。
     * 找环简单，快慢指针就秒了。但找环的入口确实有点难。
     * 从数学角度思考，假设从头结点到入口有x个节点，从入口到相遇点有y个节点，从相遇点回到入口有z个节点。
     * 也就是说，快指针走了x+y+n(y+z)个节点，而慢指针走了x+y个节点，慢指针一定一圈以内能搞定。
     * 我们希望求x，此时有x+y+n(y+z)==2x+2y，整理得到x=n(y+z)-y,即x = (n-1)(y+z) + z
     * 如何求x？x就是绕一定的环数，然后再加上z，也就是说，如果定义两个指针，一个在头结点，一个在快慢指针相遇节点（X+Y)位置，然后两者同时开始移动，在z个节点后，快指针会在环入口
     * 接着不停绕圈，直至n-1圈后，此时两者都会在环入口相遇
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while ( true ){
            //这里忘了一件事，最开始写的是fast不能==slow，但是一开始fast就是==slow的，所以压根不会进循环，为了避免这个情况，单独把while条件拿出来写了个if
            if ( fast == null || fast.next == null || fast.next.next == null){
                return null;
                //此时说明无环，直接返回
            }
            fast = fast.next.next;
            slow = slow.next;
            if ( fast == slow ){
                break;
            }
        }
        //此时fast和slow在一起咯！将slow放回头节点，接着开始走。
        slow = head;
        while ( fast != slow ){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(fast.val);
        return fast;
    }
}
