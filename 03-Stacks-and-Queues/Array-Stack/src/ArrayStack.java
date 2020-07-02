public class ArrayStack<E> implements Stack<E> {

    Array<E> arr;

    public ArrayStack(int capactiy) {
        arr = new Array<E>(capactiy);
    }

    public ArrayStack() {
        arr = new Array<E>();
    }

    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public E peek() {
        return arr.getLast();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int getCapacity() {
        return arr.getCapactiy();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Stack : [");
        for (int i = 0; i < arr.getSize(); i ++) {
            ret.append(arr.get(i));
            if (i != arr.getSize() - 1) {
                ret.append(", ");
            }
        }
        ret.append(" ] top");
        return ret.toString();
    }
}
