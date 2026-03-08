/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-08
 * Time: 08:08
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
    //110. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        //空树也是平衡二叉树
        if(root==null) return true;
        int lefthight=gethight(root.left);
        int righthight=gethight(root.right);
        return Math.abs(lefthight-righthight)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    private int gethight(TreeNode root){
        if(root==null) return 0;
        int lefthight=gethight(root.left);
        int righthight=gethight(root.right);
        return lefthight>righthight?lefthight+1:righthight+1;
    }
}