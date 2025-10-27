import java.util.Stack;

/**32.最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"
 */
public class _0032_LongestValidParenthese {
    public int longestValidParentheses(String s) {

//        return stack(s);
        return doublePoint(s);
    }
    public int stack(String s){
        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < charArray.length; i++) {
            if ('('==charArray[i]){
                stack.push(i);
            } else if (')'==charArray[i]) {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }

        }
        return max;
    }
    public int doublePoint(String s){
        final char[] charArray = s.toCharArray();
        int max =0;
        int left=0;
        int right =0;
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i]=='('){
                left++;
            }else {
                right++;
            }
            if(left==right){
                max= Math.max(max,left);
            } else if (right>left) {
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (charArray[i]=='('){
                left++;
            }else {
                right++;
            }
            if (left==right){
                max = Math.max(max,left);
            }else if (left>right){
                left=0;
                right=0;
            }
        }
        return max *2;
    }
    public int dp(String s){
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
    new _0032_LongestValidParenthese().longestValidParentheses("(()");
    }
}
