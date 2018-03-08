import java.util.Stack;

/**
 * Created by woo23 on 2018/3/6.
 * 112. Path Sum
 * 给定一个二叉树，和一个数n，求这颗树当中有没有一个从根节点到叶子节点的和是n的路径如果有返回true
 *
 * 解法：这道题应该是一道带回溯的深度优先搜索的问题，但是我不记得怎么写深度优先搜索了,如果使用栈来进行深度优先搜索的话不好记录下当前的sum值。
 */
import java.util.Stack;
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        if(root.right==null&&root.left==null&&sum-root.val==0) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

//        解法2


    }
}
