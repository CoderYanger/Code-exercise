/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-10
 * Time: 21:23
 */

import javax.swing.tree.TreeNode;

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
    //1339. 分裂二叉树的最大乘积
    private static final int MOD=1_000_000_007;
    private long ret=0;
    private int total;
    public int maxProduct(TreeNode root) {
        total=dfs1(root);
        dfs2(root);
        return (int)(ret%MOD);
    }
    private int dfs1(TreeNode node){
        if(node==null) return 0;
        return node.val+dfs1(node.left)+dfs1(node.right);
    }
    private int dfs2(TreeNode node){
        if(node==null) return 0;
        int t=node.val+dfs2(node.left)+dfs2(node.right);
        ret=Math.max(ret,(long)t*(total-t));
        return t;
    }
}
