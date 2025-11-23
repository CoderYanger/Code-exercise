/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-23
 * Time: 23:24
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
    //814. 二叉树剪枝
    //一开始自己照着思路试着写，结果不对，注释掉了，后来看吴小哲敲完之后，自己又敲了一遍

    // public TreeNode pruneTree(TreeNode root) {
    //     return dfs(root);
    // }
    // public TreeNode dfs(TreeNode root){
    //     if(root.val==0) return null;
    //     TreeNode left=dfs(root.left);
    //     TreeNode right=dfs(root.right);
    //     if(left==null&&right==null) {root=null;return null;};
    //     return left==null?null:left;
    //     return right==null?null:right;
    // }
    public TreeNode pruneTree(TreeNode root){
        if(root==null) return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.left==null&&root.right==null&&root.val==0) root=null;
        return root;
    }
}