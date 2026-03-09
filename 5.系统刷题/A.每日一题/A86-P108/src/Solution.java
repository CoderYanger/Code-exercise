/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-11
 * Time: 11:36
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
    //108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length);
    }
    //把nums[left]到nums[right-1]转成平衡二叉树
    private TreeNode dfs(int[] nums,int left,int right){
        if(left==right) return null;
        int mid=left+(right-left)/2;
        //帮你把mid的左右区间分开，成为新子树后利用构造方法给你接上
        return new TreeNode(nums[mid],dfs(nums,left,mid),dfs(nums,mid+1,right));
    }
}