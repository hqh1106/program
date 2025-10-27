import java.util.*;

/** 139 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用
 *
 * tag: hot100, 动态规划
 */
public class _0139_WordBreak {
    /** 思路：找中断点，每次找到单词匹配的结尾，从之前遍历中有效的结尾开始，找到单词能拼接成的下一个结尾，最后一个为true，表示可以组成
     *
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();

        for (String s1 : wordDict) {
            set.add(s1);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] =true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
