/**
 * 3 — DeleteList()
 * 删除所有节点，并将head指向NULL
 */
public class Solution3 {

    public void deleteList (ListNode head) {

        ListNode dummyHead = new ListNode(null);
        dummyHead.next = head;

        while (dummyHead.next != null) {
            ListNode deleNode = dummyHead.next;
            dummyHead.next = dummyHead.next.next;
            deleNode = null;
        }
        dummyHead = null;
    }

    //测试
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        Solution3 solution = new Solution3();
        solution.deleteList(listNode);

        System.out.println(listNode);
    }
}
