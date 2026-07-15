/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-14
 * Time: 20:59
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
    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int getleft=maxDepth(root.left);
        int getright=maxDepth(root.right);
        return Math.max(getleft,getright)+1;
    }
}
