public interface Queue<E> {
    void enQueue(E e);

    E deQueue();

    E getFront();

    boolean isEmpty();

    int getSize();
}
