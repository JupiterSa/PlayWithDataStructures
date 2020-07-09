public class ArrayQueue<E> implements Queue<E>{

    Array<E> array;

    public ArrayQueue(int capacitiy) {
        array = new Array<>(capacitiy);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapactiy();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Queue : front [");
        for (int i = 0; i < array.getSize(); i ++) {
            String val = String.valueOf(array.get(i));
            if (i != array.getSize() -1) {
                ret.append( val + ", ");
            }else {
                ret.append(val + "] tail. Size: " + String.valueOf(array.getSize()) + " capacity: " + String.valueOf(array.getCapactiy()));
            }
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        // write your code here
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10; i ++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2) {
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }
    }
}
