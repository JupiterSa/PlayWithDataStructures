public class LinkedListQueue<E> implements Queue<E> {

    //不复用之前写好的只有head的LinkedList类
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }


    private Node head;
    private Node tail;
    private int size;



    public LinkedListQueue () {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enQueue(E e) {
        //new一个Node对象，用来装新增的节点
        Node node = new Node(e);
        //如果tail指向null，说明没有队列为空
        if (tail == null) {//队列头部，栈的尾部为空
            tail = node; //将tail指向新增node的地址
            head = tail; //只有一个节点的情况下，要维护head
        } else {
            tail.next = node;  //将tail.next指向新的节点，新节点挂上了
            tail = tail.next; //!!! tail = node 也对吗？  移动tail
        }
        size ++;
    }

    @Override
    public E deQueue() {
        //空不能出队
        if (isEmpty()) {
            throw new IllegalArgumentException("The LinkedListQueue is empty.");
        }
        //new一个Node对象，用来装删掉的节点
        Node delNode = head;
        //将head后移
        head = head.next;
        //将被删除的节点指向null
        delNode.next = null;
        //如果移动后head==null,说明队列变成空了，也要改变tail
        if (head == null) {
            tail = null;
        }
        size --;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The LinkedListQueue is empty.");
        }
        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString () {
        StringBuilder ret = new StringBuilder();
        ret.append("LinkedListQueue : front ");
        Node cur = head;
        while (cur != null) {
            ret.append(cur.e + "-> ");
            cur = cur.next;
        }
        ret.append("null");
        return ret.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i ++) {
            linkedListQueue.enQueue(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2) {
                linkedListQueue.deQueue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
