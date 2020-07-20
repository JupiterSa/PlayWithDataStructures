/**
 * 6 — SortedInsert()
 * 将node插入升序存储的链表的适当位置
 */
public class Solution6 {
    public void SortedInsert (ListNode head, int insertValue) {

        ListNode dummyHead = new ListNode(null);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current != null && current.value < insertValue) {
                current = current.next;
        }
        ListNode newNode = new ListNode(insertValue);
        newNode.next = current.next;
        current = newNode;
    }
}
