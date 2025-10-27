import java.util.ArrayList;
import java.util.List;

/**44.二叉树展开为链表
 *
 */
public class _0044_Flatten {
    public void flatten(TreeNode root) {
//        iter(root);
        inplace(root);
    }

    public void inplace(TreeNode root){
        // 把当前节点的右子树放到左子树最右的节点的右节点，然后再把左子树移动到当前节点的右子树上，左节点置空
        TreeNode curr = root;
        while (curr !=null){
            if (curr.left !=null){
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right!=null){
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left =null;
                curr.right = next;
            }
            curr =curr.right;
        }
    }
    public void iter(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root,list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1),curr = list.get(i);
            pre.left=null;
            pre.right=curr;
        }
    }
    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if (root!=null){
            list.add(root);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }
}
