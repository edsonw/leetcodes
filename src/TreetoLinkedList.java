import java.util.Stack;

/**
 * Created by woo23 on 2018/7/21.
 */

public class TreetoLinkedList {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
        public static  TreeNode Convert(TreeNode root) {
       /*TreeNode lastnode = null;
       lastnode = helper(root,lastnode);
       TreeNode head = lastnode;
       while(head!=null&&head.left!=null){
           head = head.left;
       }
        return head;
        */
            Stack<TreeNode> stack = new Stack<TreeNode>();

            TreeNode node = root;
            TreeNode pre = null;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                if (!stack.isEmpty()) {
                    TreeNode curr = stack.pop();
                    curr.left = pre;
                    if (pre != null) {
                        pre.right = curr;

                    }
                    pre = curr;
                    node = curr.right;
                }
            }
            TreeNode head = pre;
            while (head != null && head.left != null) {
                head = head.left;
            }
            return head;
        }

}
