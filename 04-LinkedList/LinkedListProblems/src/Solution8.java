/**
 * 8 — Append()
 * 将一个链表连到零一个链表的尾部
 * Write an Append() function that takes two lists, 'a' and 'b', appends 'b' onto the end of 'a',
 * and then sets 'b' to NULL (since it is now trailing off the end of 'a'). Here is a drawing of
 * a sample call to Append(a, b) with the start state in gray and the end state in black. At the
 * end of the call, the 'a' list is {1, 2, 3, 4}, and 'b' list is empty.
 */
public class Solution8 {
    public ListNode Append (ListNode headA, ListNode headB) {

        if (headA == null) {
            headA = headB;
        } else {
            //先循环A表到最后一个节点
            ListNode current = headA;
            while (current.next != null) {
                current = current.next;
            }

            //循环所有B节点，将其添加到A的最后面
            while (headB != null) {
                current.next = headB;
                headB = headB.next;
                current = current.next;
            }
        }
        return headA;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3};
        ListNode listNode1 = new ListNode(nums1);
        int[] nums2 = {1,2,3};
        ListNode listNode2 = new ListNode(nums2);
        System.out.println(listNode1);
        System.out.println(listNode2);

        Solution8 solution = new Solution8();
        solution.Append(listNode1,listNode2);

        System.out.println(listNode1);
    }
}
