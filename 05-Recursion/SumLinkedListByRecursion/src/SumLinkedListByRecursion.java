public class SumLinkedListByRecursion {
    public static int sum (ListNode head) {
        return sumRecursion(head);
    }

    private static int sumRecursion (ListNode head) {
        if (head == null) {
            return 0;
        }
        return head.val + sum(head.next);
    }

    public static void main(String[] args) {
        int[] array = {5,4,3};

        ListNode head = new ListNode(array);
        System.out.println("ListNode:" + head);

        System.out.println("Sum:" + sum(head));
    }

}
