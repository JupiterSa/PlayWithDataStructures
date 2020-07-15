public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    //自己测试代码，需要调用solution中的removeElements(ListNode head, int val)
    //所以我们自己构造出 ListNode head！！！
    //新创建一个构造函数
    public ListNode (int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            throw new IllegalArgumentException("The array can not be empty.");
        }

        //这个this 就是创建的链表的头节点！！！！
        this.val = arrs[0]; //对于ListNode来说，第一个元素就是head，而且要给val赋值！！！ 接着把下面的元素接起来

        ListNode current = this; //!!!! 从第一个节点开始！！！！
        for (int i = 1; i < arrs.length ; i ++) {
            current.next = new ListNode(arrs[i]);
            current = current.next;
        }

    }

    //！！！以当前节点为头节点的链表信息字符串！！！！！！！！！
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("ListNode : head ");

        ListNode cur = this; //从当前节点开始循环
        while (cur != null) {
            ret.append( cur.val + "-> ");
            cur = cur.next;
        }
        ret.append("null");

        return ret.toString();
    }
}
