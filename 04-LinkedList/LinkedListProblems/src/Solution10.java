/**
 * 10 RemoveDuplicates()
 * 给定一个升序链表，删除重复元素
 * Write a RemoveDuplicates() function which takes a list sorted in increasing order and
 * deletes any duplicate nodes from the list. Ideally, the list should only be traversed once.
 */
public class Solution10 {
    //循环方法
    public void RemoveDuplicates1 (ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            if (current.value == current.next.value) {
                ListNode delNode;
                delNode = current.next;
                current.next = current.next.next;
                delNode = null;
            } else {
                current = current.next;
            }
        }
    }

    //递归方法
    public void RemoveDuplicates2 (ListNode head) {


    }
}
