/**
 * Created by woo23 on 2018/3/9.
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 leetcode 110
 给定一颗二叉树，计算这颗二叉树当中除叶子节点外所有节点的左子树和右子树的高度差是否高度小等于1.

 思路：这道题我的思路首先是一个递归的算法，要分别计算左子树和右子树两者之间的的深度，这里边可以用到之前的一个计算一棵树的深度的算法，这个算法分别计算左子树和右子树的深度游
 */
public class BalancedBinaryTree {
    public boolean solve(TreeNode root){
        if(root==null)
            return true;
        int left = depth(root.left);
        int rigth = depth(root.right);
        return Math.abs(left-rigth)<=1&&solve(root.left)&&solve(root.right);
    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
