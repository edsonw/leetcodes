import com.sun.org.apache.regexp.internal.RE;
import java.util.Stack;
/**
 * Created by woo23 on 2017/12/1.
 *
 */

/**
 * 根据一颗树的前序和中序遍历重建一棵树
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class rebuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {



        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    private TreeNode reConstructBinaryTree(int [] pre,int startpre, int endpre,int [] in,int startin,int endin){
        if(startpre>endpre||startin>endin){
            return null;
        }
        TreeNode root = new TreeNode(pre[startpre]);
            for(int i =startin;i<=endin;i++){
                if(in[i]==pre[startpre]){
                    root.left = reConstructBinaryTree(pre,startpre+1,startpre+i-startin,in,startin,i-1);
                    root.right = reConstructBinaryTree(pre,i-startin+startpre+1,endpre,in,i+1,endin);
                }

            }
        return root;
    }


    /**
     * 使用两个栈实现一个队列的push和pop操作
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }

}
