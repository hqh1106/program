/**46.二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class _0046_MaxPathSum {
    int maxSum =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**思路：计算路径和时，计算当前根节点作为左右子树的路径连接点的路径和，更新最大值
     * 节点不重复，因此需要返回 左右子树最大和加上根节点，返回给上层节点
     */
    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        maxSum = Math.max(left + right+ root.val,maxSum);

        return Math.max(left,right) + root.val;
    }
}