package JZoffer;

import java.util.HashMap;

/**
 * Created by woo23 on 2018/6/12.
 * 剑指offer26 比较一颗树是否是另一颗树的子树
 */
public class CompareTwoTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

//        if (root2 == null)
//            return true;
//        if (root1.val == root2.val){
//            if (HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right)){
//               return true;
//            } else {
//              return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
//            }
//        } else {
//            HasSubtree(root1.right, root2);
//            HasSubtree(root1.left, root2);
//        }
//        return false;
        //如果要查找的树为空或者root1为空都返回false
        if(root1 == null || root2 == null)
            return false;
//        用递归的算法来计算主树的各个节点与要查找的树是否相同
        return issub(root1,root2)||HasSubtree(root1.left, root2)||HasSubtree(root1.right,root2);
    }
    public boolean issub(TreeNode root1,TreeNode root2) {
//        如果root1是空，说明
        if (root1 == null)
            return true;
        if (root2 == null)
            return false;
        if (root1.val == root2.val && issub(root1.left, root2.left) && issub(root1.right, root2.right)){
            return true;
        } else {
            return false;
        }
    }

// 第二种解决办法，更加直观一点
    /*
    *首先用递归的方法判断根节点，如果根节点的值相同才使用辅助函数判断叶子节点。
    *判断叶子节点也是是用递归的方法，如果叶子节点为空了就说明前面的都相同了可以返回true，如果叶子节点不为空但是根节点为空了说明结构不一样了，需要返回false。
    * 然后如果两个节点的值不同就返回false 如果相同就继续比较左右两个叶子节点。
    *
    * */

    public boolean HasSubtree2(TreeNode root1,TreeNode root2) {

        boolean result = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result = issub2(root1.left,root2.left)&&issub2(root1.right,root2.right);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;

    }

    public boolean issub2(TreeNode root1,TreeNode root2){
        if(root2==null)return true;
        if(root1==null)return false;
        if(root1.val!=root2.val)
            return false;
        return  issub2(root1.left,root2.left)&&issub(root1.right,root2.right);


    }
}
