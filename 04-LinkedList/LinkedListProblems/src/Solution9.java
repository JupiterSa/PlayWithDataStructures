/**
 * 9 — FrontBackSplit()
 * 将一个链表分解成两个链表
 */
public class Solution9 {
    public int countLinkedList (ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length ++;
            current = current.next;
        }
        return  length;
    }

    //方法一 先得到第一条，然后剩下的是第二条
    public void FrontBackSplit1 (ListNode source,ListNode front, ListNode end) {
        int count = countLinkedList(source);

        ListNode current = source;
        if (count < 2) {
            front = source;
            end = null;
        } else  {
            int frontLength = (count + 1) / 2;
            //找到被切断的位置
            for (int i = 0; i < frontLength; i ++) {
                current = current.next;
            }
            //通过切断的位置构造front和end
            front = source;
            end = current.next;
            //在这里，将current 与 后面的链表断开
            current.next = null;
        }
    }


    //方法二 用 fast和slow两个指针
    public void FrontBackSplit2 (ListNode source,ListNode front, ListNode end) {
        int count = countLinkedList(source);
        //快慢节点  fast是slow移动速度的两倍
        ListNode fast = source;
        ListNode slow = source;

        //中间节点
        ListNode middle;

        if (source == null || source.next.next == null) {
            front = source;
            end = null;
        } else {
            while (fast.next != null || fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 当快指针到达链表表尾时,此时慢指针指向链表中点
            middle = slow;
            front = source;
            end = middle.next;
            middle.next = null;

        }
    }

    public static void main(String[] args) {

        int[] nums = {1};
        ListNode listNode = new ListNode(nums);

        ListNode front = null;
        ListNode end = null;

        Solution9 solution9 = new Solution9();
        System.out.println(solution9.countLinkedList(listNode));

        solution9.FrontBackSplit1(listNode, front, end);

        System.out.println(front);
        System.out.println(end);


    }

}
