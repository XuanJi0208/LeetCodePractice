public class Q0002 {
    //给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //你可以假设除了数字 0 之外，这两个数都不会以 0开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //做的第一道中等难度题，有点紧张
        //想起来很容易，一位位顺着加过去，如果加起来大于10，则利用一个int，每次循环如果进位为1，则给结果+1并把int置为0；
        int jinwei = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {//两个链表目前都为空,跳出循环
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + jinwei;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }//把节点做进去
            //接下来判断进位存不存
            if (sum >= 10) {
                jinwei = 1;
            } else {
                jinwei = 0;
            }//弄好进位的值
            if (l1 != null) {//当前不为空就继续往下走，否则就停了吧，一直空就行了。
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }//走完l1，l2
        }//走出while循环，现在l1和l2都空了，检查进位是不是为1；
        if (jinwei == 1) {
            //如果是1的话，在这个节点后面再加一个1
            tail.next = new ListNode(jinwei);
            tail = tail.next;
        }
        return head;
    }

}
