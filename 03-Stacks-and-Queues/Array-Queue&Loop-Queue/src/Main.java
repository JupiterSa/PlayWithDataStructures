import java.util.Random;

public class Main {
    //比较ArrayQueue和LoopQueue性能

    //参数使用Queue接口，是为了既可以传入ArrayQueue，又可以传入LoopQueue，以实现多态
    //测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double TestQueue(Queue<Integer> q, int operationCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i ++) {
            q.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i ++) {
            q.deQueue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0; //注意这里， .0
    }

    public static void main(String[] args) {

        int operationCount = 100000;

        //ArrayQueue : enqueue(E)     均摊O(1)
        //ArrayQueue : dequeue()      O(n)
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayTime = TestQueue(arrayQueue,operationCount);
        System.out.println("ArrayQueue : " + arrayTime);

        //LoopQueue : enqueue(E)     均摊O(1)
        //LoopQueue : dequeue()      均摊O(1)
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = TestQueue(loopQueue,operationCount);
        System.out.println("LoopTime : " + loopTime);

    }
}
