import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 416.分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 */
/*
示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class _0416_CanPartition {
    /**思路：前提，和为奇数不可分割，和为偶数且有元素组合成为和/2可分割
     * 数组每个位置只能使用0/1次，因此，只能通过倒叙去查
     * 即，当前目标数-当前位置数时，之前位置是不是能够组合出来差值
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }
}
