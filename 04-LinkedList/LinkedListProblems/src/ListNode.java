public class ListNode {



    int value;
    ListNode next;

    public ListNode (int x) {
        this.value = x;
        this.next = null;
    }

    public ListNode (int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array can not be empty.");
        }

        this.value = array[0];

        ListNode current = this;
        for (int i = 1; i < array.length; i ++) {
            ListNode newNode = new ListNode(array[i]);
            current.next = newNode;
            current = current.next;
        }
    }

    //省略
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append("ListNode : head ");

        ListNode currrent = this;
        while (currrent != null) {
            res.append(currrent.value + "-> ");
            currrent = currrent.next;
        }

        res.append("null");
        return res.toString();
    }
}
