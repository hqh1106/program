/**48.只出现一次的数字
 */
public class _0048_SingleNum {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num^nums[i];
        }
        return num;
    }
}
