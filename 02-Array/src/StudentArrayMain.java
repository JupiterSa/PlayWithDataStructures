public class StudentArrayMain {
    private String name;
    private int age;

    public StudentArrayMain(String n, int a) {
        this.name = n;
        this.age = a;
    }

    @Override
    public String toString() {
        String ret = String.format("student : name = %s, age = %d \n", name, age);
        return ret;
    }


    public static void main(String[] args) {
        Array<StudentArrayMain> arr = new Array<>(2);
        arr.addLast(new StudentArrayMain("AAA", 10));
        arr.addLast(new StudentArrayMain("BBB", 12));
        arr.addLast(new StudentArrayMain("CCC", 10));

        System.out.println(arr);
    }

}
