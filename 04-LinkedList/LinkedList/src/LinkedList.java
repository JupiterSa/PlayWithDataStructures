public class LinkedList<E> {

    //内部类，只能LinkedList内部访问，对外部用户屏蔽底层实现细节
    private class Node{
        public E e;       //做成public，在LinkedList中可以改变和访问
        public Node next; //指向下一个Node的引用地址

        //构造
        public Node(E e, Node next) {
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

    private Node head; //指向链表头部的引用地址
    private int size;  //链表中有效元素个数

    //LinkedList的构造函数，对于空LinkedList，里边都是空
    public LinkedList() {
        head = null;
        size = 0;
    }
    //传入数组，等到一个链表
    public LinkedList(E[] arrs) {
        head = null;
        for (int i = arrs.length - 1; i >= 0 ; i --) {
            Node node = new Node(arrs[i]);
            node.next = head;
            head = node;
            //另一种写法
//            head = new Node(arrs[i],head);
        }
        size = arrs.length;
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
        Node currentNode = head;
        while (currentNode != null) {
            res.append(currentNode.e + "-> ");
            currentNode = currentNode.next;
        }
        res.append("null    size:" + getSize());
        return res.toString();
    }

    //增

    //在链表头添加元素 addHead  addFirst
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        //另一种写法
        //①new一个新的Node节点对象 ②使其存入e,指向的第一个节点(即head指向的节点) ③移动head，使其指向新做成的节点
        //这里有一个注意点!!!! 对于一个链表，head本身就代表着第一个元素，即head指向的是第一个元素的地址，而head->next就代表了第二个元素
        //head = new Node(e,head);
        size ++;

        //可以直接复用add(e,0);
    }
    public void addLast(E e) {
        Node currentNode = head;
        //移动节点，使其到达最后一个有效的元素的地址
//        for(int i = 1; i < size; i ++) {
//            currentNode = currentNode.next;
//        }
        //另一种写法
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        //添加最后的节点
        Node node = new Node(e);
        currentNode.next = node;
        size ++;

        //可以直接复用add(e,size);
    }

    //在链表中间添加元素
    //在“索引”为n的地方添加元素
    //索引这一思想在链表的实际使用中并不常用，是为了练习四维和面试
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index need to be between 0 and size.");
        }
        Node node = new Node(e);
        //如果添加位置在0 即头部节点，head是没有prev的，索引这里要特殊处理
        if (index == 0) {
            node.next = head;
            head = node;
        }else {
            Node prev = head;//创建一个指针引用，命名previous,意为将要插入的位置的前一个node,初始位置是head
            for (int i = 1; i < index; i ++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size ++;
    }

    //优化：上一个方法中需要特殊处理head。（因为head没有previous，后边的都有pre，包括最后的null）
    //对于链表头添加和其他位置添加，逻辑上是有区别的
    //优化方法！！！：为head设立一个虚拟的头节点，可以将头部操作和其他操作统一起来

    public void addWithDummyHead(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail. Illegal index.");
        }

        Node dummyHead = new Node(null, head);//虚拟头节点里不放东西，且指向head

        Node node = new Node(e);
        Node prev = head;//prev代表要找的元素的前一个节点，prev从头节点开始寻找
        for (int i = 1; i < index; i ++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size ++;
    }

    public static void main(String[] args) {
        //测试构造函数传入数组，生成链表的功能
        Integer[] array = {1,2,3};
        LinkedList<Integer> linkedList = new LinkedList<Integer>(array);
        System.out.println(linkedList);

        linkedList.addFirst(4);
        System.out.println(linkedList);

        linkedList.addLast(5);
        System.out.println(linkedList);

        linkedList.add(666,2);
        System.out.println(linkedList);

        linkedList.add(777,0);
        System.out.println(linkedList);
    }


}
