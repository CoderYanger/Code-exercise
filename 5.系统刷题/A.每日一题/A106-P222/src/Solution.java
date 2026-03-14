/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 21:21
 */

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

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
    //222. 完全二叉树的节点个数
    //解法一：递归遍历
    public int countNodes(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if(node==null) return 0;
        return dfs(node.left)+dfs(node.right)+1;
    }

    //解法二：层序遍历
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int cnt=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            cnt++;
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
        return cnt;
    }
}
