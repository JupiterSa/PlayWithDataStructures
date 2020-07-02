public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        System.out.println(arrayQueue);

        arrayQueue.deQueue();
        System.out.println(arrayQueue);
    }
}
