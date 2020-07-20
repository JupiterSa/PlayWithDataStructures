/**
 *2 — GetNth()
 * 返回链表中规定索引位置的值
 * The index should be in the range [0..length-1]
 */
public class Solution2 {
    private int GetNth(ListNode listNode, int index) {

        if (listNode == null) {
            throw new IllegalArgumentException("The ListNode can not be empty.");
        }

        int res = 0;
        int count = 0;
        while (listNode != null) {
            if (count == index) {
                res = listNode.value;
            }
            count++;
            listNode = listNode.next;
        }
        return res;
    }
}
