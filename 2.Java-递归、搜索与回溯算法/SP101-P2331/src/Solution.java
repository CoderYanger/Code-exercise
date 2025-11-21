/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-23
 * Time: 21:23
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //自己照着思路写的，一遍过
    public boolean evaluateTree(TreeNode root) {
        //递归出口：遇到叶子节点
        if(root.left==null||root.right==null){
            if(root.val==0) return false;
            else return true;
        }
        boolean left=evaluateTree(root.left);
        boolean right=evaluateTree(root.right);
        if(root.val==2) return left|right;
        else return left&right;
    }
    //按着吴小哲简化了一下代码，跟我写的一样的
    public boolean evaluateTree(TreeNode root) {
        //递归出口：遇到叶子节点
        if(root.left==null) return root.val==0?false:true;
        boolean left=evaluateTree(root.left);
        boolean right=evaluateTree(root.right);
        return root.val==2?left|right:left&right;
        //在boolean类型中&和|分别为逻辑与和逻辑或，不论第一个是什么都会执行第二个的判断
    }
}