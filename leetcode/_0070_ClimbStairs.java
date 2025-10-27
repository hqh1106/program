/** 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * tag: hot100, 动态规划, 滚动数组
 */
/*
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
 */
public class _0070_ClimbStairs {
    public int climbStairs(int n) {
//        return climbStairs1(n);
//        return climbStairs2(n);
        return climbStairs3(n);
    }

    public int climbStairs1(int n) {
        // 包含大量重复计算，时 O(2^n),空 O(n)
        if (n == 1 || n == 0) {
            return 1;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
    public int climbStairs2(int n) {
        //自底向上的动态规划，用数组存储中间结果,时 O(n),空 O(n)
        int[] arr = new int[n+1];
        arr[0]=arr[1]=1;
        for (int i = 2; i <=n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public int climbStairs3(int n) {
         // n 的次数只与 n-1 和 n-2有关，只需分别记录依次滑动
        //|p|q|r|
        //  |p|q|r|
        //    |p|q|r|
        int q = 0, p = 0, r = 1;
        for (int i = 1; i <= n ; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    public static void main(String[] args) {
        new _0070_ClimbStairs().climbStairs(3);
    }
}
