/**
 * Created by woo23 on 2018/3/4.
 * 带分层的二叉树的层次遍历。
 * 对于二叉树的层次遍历一般都是用的队列来实现的，根据队列当中的先入先出的策略我们首先加入的一个节点的左右两个儿子节点，然后挨个弹出，在弹出的时候再加入这两个儿子节点的孙子节点，这样遍历完叻了儿子节点就接着遍历孙子节点，如果我们要实现一个计算分层的，就需要记录下当加入了一层节点之后的大小，然后遍历该层大小次，就能实现区分每一层。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size()>0){
            List<Integer> littelist = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size; i++){
                TreeNode node  = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);

            }
            list.add(0,littelist);
        }
        return list;
    }
}
