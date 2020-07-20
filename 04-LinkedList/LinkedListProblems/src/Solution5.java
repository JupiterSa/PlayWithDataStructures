/**
 * 5 — InsertNth()
 * 在指定的index位置插入一个节点
 */
public class Solution5 {

    public boolean InsertNth(ListNode head, int value, int index) {

        boolean res = false;
        int count = 0;
        for (ListNode current = head; current.next != null; current =current.next) {
            if (count == value) {
                ListNode newNode = new ListNode(value);
                newNode.next = current.next;
                current.next = newNode;
                res = true;
            }
            count ++;
        }

        return res;
    }

    public void InsertNth2 (ListNode head, int value, int index) {
        ListNode newNode = new ListNode(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {

        }
    }
}
