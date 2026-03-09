/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-11
 * Time: 10:51
 */

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

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
    //94. 二叉树的中序遍历
    //解法一：递归
    List<Integer> ret;
    public List<Integer> inorderTraversal(TreeNode root) {
        ret=new LinkedList<>();
        dfs(root);
        return ret;
    }
    private void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        ret.add(node.val);
        dfs(node.right);
    }

    //解法二：栈
    List<Integer> ret;
    public List<Integer> inorderTraversal(TreeNode root) {
        ret=new LinkedList<>();
        dfs(root);
        return ret;
    }
    private void dfs(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=node;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            ret.add(top.val);
            cur=top.right;
        }
    }
}
