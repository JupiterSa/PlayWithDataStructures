public class LoopQueueWithoutSize<E> implements Queue<E> {

    private int front;
    private int tail;

    private E[] data;

    public LoopQueueWithoutSize (int capacity) {
        data = (E[])new Object[capacity];
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

        return 0;
    }

    public int getCapacity () {
        return data.length - 1;
    }

    @Override
    public void enQueue(E e) {

    }
    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public String toString () {
        return null;
    }

    
}
