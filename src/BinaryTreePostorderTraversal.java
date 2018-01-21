/**
 * Created by woo23 on 2018/1/17.
 * leetcode 145二叉树的后后序遍历
 *
 */
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 使用非递归的方法对二叉树进行后序遍历，这里使用linklist，linklist当中的addfirst可以将元素插入到头部，这样就相当于是一个栈。先遍历中节点下一个接下来遍历右节点，并且我们使用一个栈记录下遍历的节点。栈当中的节点就是二叉树右边的路径。但是由于返回结果我们使用的是相当于栈的链表，所有中右左的顺序就变成了做右中的顺序了，这样就实现了树的后序遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.empty() || p != null){
            if (p != null){
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;

            } else {
              TreeNode node  =  stack.pop();
              p = node.left;
            }
        }

//        todo:完成二叉树的后序遍历（非递归）
        return result;
    }

//    递归版
    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();
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
