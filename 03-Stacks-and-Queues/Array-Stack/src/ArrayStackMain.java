public class ArrayStackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        for (int i = 0; i < 5; i ++) {
            stack.push(i);
        }
        System.out.println(stack + " " + String.valueOf(stack.getCapacity()));
        stack.push(16);
        System.out.println(stack + " " + String.valueOf(stack.getCapacity()));
        stack.pop();
        System.out.println(stack + " " + String.valueOf(stack.getCapacity()));
    }
}
