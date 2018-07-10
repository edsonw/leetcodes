import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by edson on 2018/7/10.
 */
public class BSTIterator {
    private Queue<Integer> queue = new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {

        helper(root);

    }
    public void helper(TreeNode root){
        if(root!=null&&root.left==null&&root.right==null){
            queue.offer(root.val);
        }else {
            if(root!=null){
                if(root.left!=null){
                    helper(root.left);
                }
                queue.offer(root.val);
                if(root.right!=null){
                    helper(root.right);
                }
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size()>0?true:false;
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
}
