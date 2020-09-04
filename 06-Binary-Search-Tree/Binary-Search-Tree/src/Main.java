public class Main {

    public static void main(String[] args) throws Exception {

        BinarySearchTreeBasic<Integer> bst = new BinarySearchTreeBasic<>();

        int[] nums = {18,22,10,14,7,19,21,33};

        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrderTraverse();
        System.out.println();
        System.out.println(bst);
        
        bst.inOrderTraverse();
        System.out.println();
        System.out.println(bst);

    }
}
