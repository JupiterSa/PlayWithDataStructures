public class LinkedListWithDummyHead<E> {

    //内部类，只能LinkedList内部访问，对外部用户屏蔽底层实现细节
    private class Node{
        public E e;       //做成public，在LinkedList中可以改变和访问
        public Node next; //指向下一个Node的引用地址

        //构造
        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();//打印每个节点的内容
        }
    }

    private Node dummyHead;
    private int size;

    //对于空LinkedList来说，里边是有一个空节点的
    public LinkedListWithDummyHead () {
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList : head ");

        //第一种写法
//        Node currentNode = dummyHead.next;
//        while (currentNode != null) {
//            res.append(currentNode.e + "-> ");
//            currentNode = currentNode.next;
//        }
        //第二种写法
        for (Node current = dummyHead.next; current != null ; current = current.next) {
            res.append(current.e + "-> ");
        }

        res.append("null    size:" + getSize());
        return res.toString();
    }

    //在链表中间添加元素
    //在“索引”为n的地方添加元素
    //索引这一思想在链表的实际使用中并不常用，是为了练习四维和面试
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index need to be between 0 and size.");
        }
        Node node = new Node(e);

        //因为有了一个dummyHead，所以初始位置设置为它，意为从这个开始循环
        //遍历的是index前一个位置，所以起名prev
        Node prev = dummyHead;//创建一个指针引用，命名previous,意为将要插入的位置的前一个node
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size ++;
    }

    public void addFirst(E e) {
        add(e,0);
    }

    public void addLast(E e) {
        add(e, size);
    }


    //删
    //删除第index索引位置的元素
    //思路，将被删除的元素A 的前一个元素P 指向A后一个元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index need to be between 0 and size.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;  //!!!!!!!!!!!!!   让retNode指向空！！！！！！！

        size --;

        return retNode.e;
    }

    public E removeFirst () {
        return  remove(0);
    }

    public E removeLast () {
        return remove(size -1);
    }

    //改
    //修改第index位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index need to be between 0 and size.");
        }
        //遍历index这个位置，所以起名curr
        Node current = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }
        current.e = e;
    }

    //查
    //获得列表中第index位置的元素(0-base)
    //不是链表中常用的操作，练习用
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index need to be between 0 and size.");
        }
        //遍历index这个位置，所以起名curr
        Node current = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

        return current.e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node current = dummyHead.next;
        //方法一
//        for (int i = 1; i < size; i ++) {
//            if ( e.equals(current.e)) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
        //方法二
        while (current.next != null) {
            if (e.equals(current.e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E getFirst () {
        return get(0);
    }

    public E getLast () {
        return get(size - 1);
    }

    public static void main(String[] args) {
        //测试dummyHead中add相关方法
        LinkedListWithDummyHead<Integer> LinkedListWithDummyHead = new LinkedListWithDummyHead<Integer>();
        System.out.println(LinkedListWithDummyHead);

        LinkedListWithDummyHead.addFirst(5);
        System.out.println(LinkedListWithDummyHead);

        LinkedListWithDummyHead.addFirst(4);
        System.out.println(LinkedListWithDummyHead);

        LinkedListWithDummyHead.addLast(6);
        System.out.println(LinkedListWithDummyHead);

        LinkedListWithDummyHead.add(3,0);
        System.out.println(LinkedListWithDummyHead);

        LinkedListWithDummyHead.add(7,4);
        System.out.println(LinkedListWithDummyHead);

    }

}
