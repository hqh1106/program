/**152.乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * tag: hot100, 动态规划
 */
public class _0152_MaxProduct {
    /**思路：如果只为正和0的情况，只需要维护一个数组就可以
     *如果存在负数，则会出现 --=+的情况，因此需要额外维护最小值数组
     */
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i]=nums[i];
            min[i]=nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i-1] * nums[i],Math.max(nums[i],min[i-1]*nums[i]));
            min[i] = Math.min(max[i-1]* nums[i],Math.min(nums[i],min[i-1]*nums[i]));
        }
        int maxNum=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum,max[i]);
        }
        return maxNum;
    }
}
