/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-24
 * Time: 09:54
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
    //自己写的，带剪枝的，一遍过
    int ret=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        dfs(root);
        return ret;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(--count==0){ret=root.val;return;}
        dfs(root.right);
    }
    //吴小哲又加了三条剪枝
    int ret=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        dfs(root);
        return ret;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        if(count==0) return;//进入左的时候判断一下，剪枝
        dfs(root.left);
        if(count==0) return;//进入中的时候判断一下，剪枝
        if(--count==0){ret=root.val;return;}
        if(count==0) return;//进入右的时候判断一下，剪枝
        dfs(root.right);
    }
}