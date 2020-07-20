/**
 * 4 — Pop()
 * Pop是Push的倒转，删除头节点，并返回该头节点的值
 */
public class Solution4 {
    public int Pop (ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("The listnode is empty.");
        }

        ListNode delNode = head;
        int popValue = delNode.value;
        head = head.next;
        delNode = null;

        return popValue;
    }
}
