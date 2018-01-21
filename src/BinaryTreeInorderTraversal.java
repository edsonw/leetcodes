/**
 * Created by woo23 on 2018/1/17.
 * 对二叉树进行中序遍历
 * 基本思想是先遍历到最左边不能再遍历的位置，然后在开始出栈，每出栈一个节点都要将其值添加到list当中。如果出栈的元素是有右节点的那么说明还可以把右边的节点继续添加到栈当中。
 */



import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p= root;
        while (!stack.empty() || p != null){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;

        }
        return list;
    }

}


