/**
 * @author XuanJi
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class R0022 {
    //双指针，一个指向head，一个指向head后k个节点，两者一起向后移动
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode tail = head;
        for(int i = 0; i < k;i++){
            tail = tail.next;
        }
        while(tail!=null){
            tail = tail.next;
            head = head.next;
        }
        return head;
    }
}
