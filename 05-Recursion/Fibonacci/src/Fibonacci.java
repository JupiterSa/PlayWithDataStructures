 public class Fibonacci {

    //李永乐老师斐波那契视频那集，有一个关于爬楼梯有多少种方式的求解过程
    //题目规定，站在楼梯下面，且每次只能走一个或者走两个，则到达第n层有多少种方式
    public long fibo(int n){

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fibo(n-1)+fibo(n-2);
    }

    //测试
    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibo(6));
    }
}
