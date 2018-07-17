import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by edson on 2018/7/11.
 */
public class PopulatingNextRightPointersinEachNodeII {

   class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
    public void connect(TreeLinkNode root) {
        if(root==null)
            return ;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int size = queue.size();
        while(size>0){
            TreeLinkNode node = queue.poll();
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);

            if(size>1){
                node.next = queue.peek();
                size--;
            }else if(size==1){
                node.next = null;
                size = queue.size();
            }

        }
    }
}
