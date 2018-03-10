/**
 * Created by woo23 on 2018/3/11.
 * 这里有一个需要注意到的是java当中对象的传递是一种值传递，对基本类型是引用传递。
 */
import java.util.List;
import java.util.LinkedList;
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new LinkedList<String>();
        if(root==null)
            return list;
        helper(root,list,"");
        return list;
    }
    public void helper(TreeNode root,List<String> list,String str){

        if(root.left==null&&root.right==null){
            list.add(str+""+root.val);
        }
        if(root.left!=null){
            helper(root.left,list,str+root.val+"->");
        }
        if(root.right!=null){
            helper(root.right,list,str+root.val+"->");
        }

    }
}
