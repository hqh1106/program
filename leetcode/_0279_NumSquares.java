/**279.完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是
 *
 * tag: hot100, 动态规划
 */
/*
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
 */
public class _0279_NumSquares {
    /** 思路：dp记录当前每个数值需要完全平方数的个数，不会出现不可能的情况，可以n个1组成
     *  依次讲计算出来的最小平方数存储dp中，从小开始计算的，因此计算n时[0,n-1]的最小个数都存在，
     *  根据n - 平方数 后在dp中找到最小的次数 +1 即可得到当前最小次数
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <=i ; j++) {
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
