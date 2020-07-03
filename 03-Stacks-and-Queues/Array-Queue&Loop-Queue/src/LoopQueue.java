public class LoopQueue<E> implements Queue<E>{

    private int front; //指向队列头部
    private int tail; //指向队列最后一个元素的下一个索引，也就是即将下一个被插入的位置
    private int size; //队列有效元素的个数

    private E[] data; //泛型数组

    //有参构造函数，并且初始化变量
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1]; //注意这里，实际new出的数组比设想new出的大1
        front = 0;
        tail = 0;
        size = 0;
    }

    //无参构造函数，调用this(),也就是调用了上面有参的构造函数
    public LoopQueue() {
        this(10);
    }

    //获取循环队列中的容量(比实际队列大小少1)
    public int getCapacity() {
        return data.length -1;
    }

    //获取循环队列中的有效元素个数
    @Override
    public int getSize() {
        return size;
    }

    //判断循环队列是否为空
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enQueue(E e) {
        //首先判断队列是否为满
        //有位移循环时要用 data.length，而不是getCapacity()
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2); //之前循环队列用户定义的大小再*2
        }
        //然后入队尾，更改tail和size
        data[tail] = e;
        tail = (tail + 1) % data.length; //tail移动需要用 %
        size ++;
    }

    @Override
    public E deQueue() {

        //首先判断队列是否为空(空不能出队)
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E frontElement;
        frontElement = data[front];
        data[front] = null;  //注意这里，data[front]出循环队列了，那么原本存在这里的需要释放，否则会造成loitering objects 闲逛对象
        front = (front + 1) % data.length; //front移动需要用 %
        size --;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) { //注意下面调用resize(参数)，这个参数!=0 ,要判断一下
            resize(getCapacity() / 2);
        }

        return frontElement;
    }

    @Override
    public E getFront() {
        //首先判断队列是否为空(空不能出队)
        if (front == tail) {
            throw new IllegalArgumentException("LoopQueue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1]; //这里要注意，再次扩容/缩容时，都要有这个+1
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : front [");

        for (int i = front; i != tail; i = (i + 1) % data.length ) {
            String val = String.valueOf(data[i]);
            if ((i + 1) % data.length != tail) {  //另一种写法i != tail -1
                res.append( val + ", ");
            }else {
                res.append(val + "] tail. Size: " + String.valueOf(data[i]) + " capacity: " + String.valueOf(getCapacity()));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 10; i ++) {
            loopQueue.enQueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                loopQueue.deQueue();
                System.out.println(loopQueue);
            }
        }
    }
}
