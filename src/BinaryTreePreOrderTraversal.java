/**
 * Created by woo23 on 2018/1/21.
 * 二叉树的前序遍历，非递归和递归版
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (!stack.empty() || p != null) {

            if (p != null){
                list.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return list;
    }

}
