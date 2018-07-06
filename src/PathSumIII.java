/**
 * Created by woo23 on 2018/3/7.
 * 给一个二叉树，求一个二叉树当中相加和微sum的路径，这个路径可以不以根节点开始，叶子节点结尾。
 *
 *
 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1
 * 有瑕疵想法，我们对树当中的每一个节点都当做是根节点来看待，但是这种看待是在每一个递归的过程中的，这样有一个缺点是某一个节点会被遍历多次，需要用一个hash表来存储遍历过的节点。
 */
public class PathSumIII {
    /*public int pathSum(TreeNode root, int sum) {

        if(root==null)
            return 0;

        helper(root,sum,true);

        return count;
    }
    public void  helper(TreeNode root ,int sum,boolean hasParent){
        if(root==null)
            return ;
        if(sum-root.val==0&&hasParent){
            System.out.println(count);
            count++;
        }
        helper(root.left,sum-root.val,true);
        helper(root.right,sum-root.val,true);
        helper(root.left,sum,false);
        helper(root.right,sum,false);
        //这样做当我们遍历其他节点的时候会导致某一个节点被遍历多次。

    }
    //正确写法
      int target;
    Set<TreeNode> visited;
    public int pathSum(TreeNode root, int sum) {
        target = sum;
        visited = new HashSet<TreeNode>();  // to store the nodes that have already tried to start path by themselves.
        return pathSumHelper(root, sum, false);
    }

    public int pathSumHelper(TreeNode root, int sum, boolean hasParent) {
        if(root == null) return 0;
        //the hasParent flag is used to handle the case when parent path sum is 0.
        //in this case we still want to explore the current node.
        if(sum == target && visited.contains(root) && !hasParent) return 0;
        if(sum == target && !hasParent) visited.add(root);
        int count = (root.val == sum)?1:0;
        count += pathSumHelper(root.left, sum - root.val, true);
        count += pathSumHelper(root.right, sum - root.val, true);
        count += pathSumHelper(root.left, target , false);
        count += pathSumHelper(root.right, target, false);
        return count;
    }


    */

    //正确写法
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
