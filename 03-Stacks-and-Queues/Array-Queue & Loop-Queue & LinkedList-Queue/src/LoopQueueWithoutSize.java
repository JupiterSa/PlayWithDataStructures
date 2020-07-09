public class LoopQueueWithoutSize<E> implements Queue<E> {

    private int front;
    private int tail;

    private E[] data;

    public LoopQueueWithoutSize (int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueWithoutSize () {
        this(10);
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The LoopQueue is empty.");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        int size;
        if (front <= tail) {
            size = tail - front;
        } else {
            size = data.length + tail - front;
        }
        //另一中写法
        //size = front <= tail ? tail - front : data.length + tail - front;
        return size;
    }

    public int getCapacity () {
        return data.length - 1;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The LoopQueue is empty.");
        }
        E ret;
        ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() / 4 && getCapacity() /2 != 0) {
            resize(getCapacity() /2);
        }
        return ret;
    }

    private void resize (int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1]; 
        int size = getSize();
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(front + i) % data.length];  //错了注意
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : front [");
        for (int i = front; i != tail ; i = (i + 1) % data.length) {
            if ((i + 1) % data.length != tail) {
                res.append(data[i] + ",");
            }else {
                res.append(data[i] + "] tail. Size: " + String.valueOf(getSize()) + " capacity: " + String.valueOf(getCapacity()));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LoopQueueWithoutSize<Integer> loopQueue = new LoopQueueWithoutSize<>();

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
