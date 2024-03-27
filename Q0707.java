/**
 * @author XuanJi
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 *
 * 大概的思路：用链表实现，先对ListNode进行一个定义，这个很重要。ListNode的定义最好能直接背下来。
 * 第二个：整个链表，主要就是考虑怎么实现所需要功能了。这个我暂时没找到很好的套路，感觉就是按需一点点加，一般这种题也不会太难为人。
 *
 *
 * 这道题主要失误在两个地方：第一个是size--忘了加了，细节问题；
 * 第二个就是没有考虑到index小于0的情况，细节问题；
 * 第三个也是最重要的：其实在head加节点或者在tail加节点可以直接用addIndex实现，不需要重复编码，这个最好注意。
 */
public class Q0707 {
    private  class ListNode {
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    private class MyLinkedList {

        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if ( index < 0 || index >= size ){
                return -1;
            }
            ListNode find = head;
            for ( int i = 0; i < index; i++ ){
                find = find.next;
                System.out.println(find.val);
            }
            return find.next.val;
        }

        public void addAtHead(int val) {
            ListNode p = new ListNode(val);
            p.next = head.next;
            head.next = p;
            size++;
        }

        public void addAtTail(int val) {
            ListNode p = new ListNode(val);
            ListNode find = head;
            while ( find.next != null ){
                find = find.next;
            }
            find.next = p;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if( index > size ){
                return;
            }
            index = Math.max(0,index);
            ListNode find = head;
            for ( int i = 0; i < index; i++ ){
                find = find.next;
            }
            ListNode p = new ListNode(val);
            p.next = find.next;
            find.next = p;
            size++;
        }

        public void deleteAtIndex(int index) {
            if( index >= size ){
                return;
            }
            ListNode find = head;
            for ( int i = 0; i < index; i++ ){
                find = find.next;
            }
            if ( find.next != null){
                find.next = find.next.next;
            }
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
