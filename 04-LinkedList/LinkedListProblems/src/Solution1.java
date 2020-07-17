/**
 * 1 — Count()
 * Write a Count() function that counts the number of times a given int occurs in a list. The
 * code for this has the classic list traversal structure as demonstrated in Length().
 * void CountTest() {
 * List myList = BuildOneTwoThree(); // build {1, 2, 3}
 * int count = Count(myList, 2); // returns 1 since there's 1 '2' in the list
 * }
 * /*
 * Given a list and an int, return the number of times that int occurs
 * in the list.
 * */
public class Solution1 {

    private int Count(ListNode listNode,int value) {
        int count = 0;
        if (listNode == null) {
            throw new IllegalArgumentException("The ListNode can not be empty.");
        }

        ListNode current = listNode;
        while (current != null) {
            if (current.value == value) {
                count ++;
            }
            current = current.next;
        }
        return count;
    }

    //测试
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        Solution1 solution = new Solution1();
        System.out.println(solution.Count(listNode,2));
    }
}
