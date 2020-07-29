/**
 * 11 — MoveNode()
 * Push的变体
 * This is a variant on Push(). Instead of creating a new node and pushing it onto the given
 * list, MoveNode() takes two lists, removes the front node from the second list and pushes
 * it onto the front of the first. This turns out to be a handy utility function to have for
 * several later problems. Both Push() and MoveNode() are designed around the feature that
 * list operations work most naturally at the head of the list. Here's a simple example of
 * what MoveNode() should do...
 */
public class Solution11 {


    ListNode firstList;
    ListNode secondList;

    private void setFirstList (int[] first) {
        firstList = new ListNode(first);
    }
    private void setSecondList (int[] second) {
        secondList = new ListNode(second);
    }

    public void MoveNode () {
        ListNode moveNode = secondList;
        secondList = secondList.next;
        moveNode.next = firstList;
        firstList = moveNode;
    }

    //测试
    public static void main(String[] args) {

        int[] first = {1,2,3};
        int[] second = {4,5};
        Solution11 solution11 = new Solution11();
        solution11.setFirstList(first);
        solution11.setSecondList(second);
        System.out.println(solution11.firstList);
        System.out.println(solution11.secondList);

        solution11.MoveNode();
        System.out.println(solution11.firstList);
        System.out.println(solution11.secondList);
    }
}
