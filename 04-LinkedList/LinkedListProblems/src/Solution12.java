/**
 * 12 — AlternatingSplit()
 * 将一个链表分成两个链表，其中一个是基数位的，一个是偶数位的
 */
public class Solution12 {

    private ListNode listNode;
    private ListNode oddList;
    private ListNode evenList;

    private void setListNode (int[] nums ) {
        listNode = new ListNode(nums);
    }

    public void AlternatingSplit() {
        int i = 1;
        ListNode current = listNode;
        while (current != null) {
            if (i % 2 == 0) {
                evenList = MoveNode(evenList,current);
            } else {
                oddList = MoveNode(oddList,current);
            }
            current = current.next;
            i ++;
        }
    }
    public ListNode MoveNode (ListNode firstList, ListNode secondList) {
        ListNode moveNode = secondList;
        secondList = secondList.next;
        moveNode.next = firstList;
        firstList = moveNode;
        return firstList;
    }

    //测试
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6};

        Solution12 solution12 = new Solution12();
        solution12.setListNode(nums);
        System.out.println(solution12.listNode);

        solution12.AlternatingSplit();
        System.out.println(solution12.oddList);
        System.out.println(solution12.evenList);
    }


}

