public class SumArrayByRecursion {

    //Sum(arr[左边界left...最后一个元素(length-1)]), 当left==lenghth时，说明左边界已经超出有效元素了

    //！！ 递归推导  ！！
    //Sum(arr[0...n-1]) = arr[0] + Sum(arr[1...n-1])
    //Sum(arr[1...n-1]) = arr[1] + Sum(arr[2...n-1])
    //........
    //Sum(arr[n-1...n-1]) = arr[n-1] + Sum()



    //用！递归！的方式计算数组的和
    //给用户设置一个sum函数，传入数组，返回总和
    public static int sum (int[] arr) {
        //这个数组从哪里到最后一直求和？
        return sumRecursion(arr, 0); //递归的初始调用，计算从 0 到 n-1 的和
    }

    //下面是真正的递归函数
    //公用求sum的方法，传入一个数组，和左边界的点。计算arr从left到n-1的和
    private static int sumRecursion (int[] arr, int left) {
        //递归需要一直缩减规模直到最基本的问题
        //这里最基本的问题是 left到了arr.length，即最后一个元素
        //数组为空的情况！！
        if (left == arr.length) {
            return 0;
        } else {
            return arr[left] + sumRecursion(arr, left + 1);
        }
    }
}
