/**
 * @author XuanJi
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Q0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode pointer = head;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                pointer.next = list1;
                list1 = list1.next;
            }
            else{
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        while(list1 != null){
            pointer.next = list1;
            list1 = list1.next;
            pointer = pointer.next;
        }
        while(list2 != null){
            pointer.next = list2;
            list2= list2.next;
            pointer =pointer.next;
        }
        return head.next;
    }
}
