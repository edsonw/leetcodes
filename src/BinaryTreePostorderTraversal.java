/**
 * Created by woo23 on 2018/1/17.
 * leetcode 145二叉树的后后序遍历
 *
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        if (root == null)
            return list;
        TreeNode p = root;

//        todo:完成二叉树的后序遍历（非递归）
        return list;
    }

//    递归版
    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root,list);
        return list;
    }
    private void helper(TreeNode node,  List<Integer> list){
        if(node.left!=null)
            helper(node.left,list);
        if (node.right != null)
            helper(node.right,list);
        list.add(node.val);

    }
}
