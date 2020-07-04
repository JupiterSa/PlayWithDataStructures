import com.sun.security.auth.module.LdapLoginModule;

public class LoopQueueWithoutWasting<E> implements Queue<E> {

    private int front;
    private int tail;
    private int size;

    private E[] data;

    public LoopQueueWithoutWasting (int capacity) {
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueWithoutWasting () {
        this(10);
    }

    public int getCapacity () {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The LoopQueue is empty.");
        }
        return data[front];
    }

    @Override
    public void enQueue(E e) {
        if (size == getCapacity()) {  //错了注意
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
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
        size --;

        if (getCapacity() == data.length / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() /2);
        }

        return ret;
    }

    private void resize (int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    //注意两种写法
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            if ( (i + 1) % data.length != tail) {
                res.append(data[i] + ",");
            }else {
                res.append(data[i] + "] tail. Size: " + String.valueOf(getSize()) + " capacity: " + String.valueOf(getCapacity()));
            }
        }

//        for(int i = 0; i < size; i ++){
//            res.append(data[(front + i) % data.length]);
//            if((i + front + 1) % data.length != tail)
//                res.append(", ");
//        }
//        res.append("] tail");

        return res.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LoopQueueWithoutWasting<Integer> loopQueue = new LoopQueueWithoutWasting<>();
        System.out.println(loopQueue);
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
