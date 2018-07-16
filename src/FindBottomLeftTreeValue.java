import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by woo23 on 2018/7/16.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return 0;
        queue.offer(root);
        int size = queue.size();
        while (size > 0){
            TreeNode node = queue.poll();
            size--;
            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
            if (size == 0 && queue.size() == 0){
                return node.val;
            } else {
                size = queue.size();
            }
        }
        return 0;
    }
}
