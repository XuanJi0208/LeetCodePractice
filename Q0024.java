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


    /**
     * 重写了一次，主要问题出在newHead这里，两个人的next不能都指着head，否则两人实质不为一个节点，head交换后会丢失。
     * 相比之前写的，要注意一个地方：之前的写法是在while循环里现场开的指针，我的是提前做的指针。之前的写法好处是不用考虑一个节点的情况了，同时最后一对的时候实质上也不需要考虑数组越界。
     * （因为本身pre这个指针是不可能越界的）
     * 但是其实运行时间和内存没有那么明显的差距，我估计是因为下面的方法只是多做了几个判断，但上面的条件涉及反复初始化node（swap）节点。
     */
    public ListNode swapPairs2(ListNode head) {
        //如果只有一个节点，则直接返回。
        if ( head == null || head.next == null ) {
            return head;
        }
        //考虑用三个指针，其中两个用于节点交换，另一个用于存储前面的那个节点，
        ListNode swap1 = head;
        ListNode swap2 = head.next;
        //这两个是用于交换的节点
        ListNode pre = new ListNode();
        ListNode newHead = new ListNode();
        pre.next = head;
        newHead = pre;
        //用于记录上一个节点的指针
        while ( swap2 != null ){
            //只要需交换的节点非空
            swap1.next = swap2.next;
            swap2.next = swap1;
            pre.next = swap2;
            //完成交换，接下来需要重置指针位置。
            pre = swap1;
            swap1 = pre.next;
            if ( swap1 == null ){
                return newHead.next;
            }
            swap2 = swap1.next;
            //思考一下，这里两个swap会越界吗？
        }
        return newHead.next;
    }
}
