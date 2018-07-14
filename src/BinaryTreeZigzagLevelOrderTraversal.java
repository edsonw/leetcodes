import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by edson on 2018/7/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null)
            return list;
        queue.add(root);
        int size = queue.size();
        boolean  flag = true;
        LinkedList<Integer> templist = new LinkedList<Integer>();
        while(size>0){

            TreeNode node = queue.poll();
            size--;
            if(flag)
                templist.add(node.val);
            else
                templist.addFirst(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
            if(size==0){
                size = queue.size();
                list.add(new LinkedList(templist));
                templist.clear();
                if(flag)
                    flag=false;
                else
                    flag = true;
            }
        }
        return list;
    }
}
