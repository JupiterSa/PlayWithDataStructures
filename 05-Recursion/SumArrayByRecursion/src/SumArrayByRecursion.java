public class SumArrayByRecursion {
    //数组求和，用递归的方法
    //为了练习递归

    //递归公式推导  单独拿出最左边元素，然后和其余的相加
    /** Sum(arr[0...n-1]) = arr[0] + Sum(arr[1...n-1])
     *  Sum(arr[1...n-1]) = arr[1] + Sum(arr[2...n-1])
     *  .......
     *  Sum(arr[n-1...n-1]) = arr[n-1] + Sum()
     */



    //该方法是给用户设计的，输入数组，返回和
    public static int sum (int[] arrs) {

        if (arrs == null) {
            throw new IllegalArgumentException("The array is illegal");
        }

        //递归体
        return sumRecursion(arrs, 0); //递归初始调用，递归从数组index=0开始

    }

    //递归方法总结： 从哪里开始递归求和  array[left .... n]
    //递归函数，递归方法体，体现公式
    private static int sumRecursion (int[] array, int left) {
        //递归基础
        if (left == array.length)
            return 0;
        return array[left] + sumRecursion(array, left + 1);
    }

    //递归画图解析
    /** 数组arr = {3，4，6，8}  index从 0~3  length=4
     * 用户调用 sumRe(arr, 0)
     *
     * 递归展开：
     * 第0层：递归开始与结束处：return sumRe(arr, 0)
     * 第一层：return arr[0] + sumRe(arr, 1)
     * 第二层：(arr[0]) + return arr[1]+sumRe(arr, 2)
     * 第三层：(arr[0] + arr[1]) + return arr[2]+sumRe(arr, 3)
     * 第四层：(arr[0] + arr[1] + arr[2]) + return arr[3]+sumRe(arr, 4)
     * 第五层：(arr[0] + arr[1] + arr[2] + arr[3]) + return 0;
     *  ！！！ 每一层的return xxxx 的解释,在下一层的括号外的部分
     *  从上往下是递
     *  从下往上是归 一层层继续返回，最后回到第0层
     */

    public static void main(String[] args) {
        // 测试数组递归方法
        int[] array = {5,4,3,2,1};
        System.out.println(sum(array));

        int[] array1 = {};
        System.out.println(sum(array1));
    }

}


