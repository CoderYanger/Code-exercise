/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-25
 * Time: 20:10
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
    //解法一：递归、搜索与回溯
    StringBuffer cur;
    int sum;
    public int sumRootToLeaf(TreeNode root) {
        cur=new StringBuffer();
        sum=0;
        dfs(root);
        return sum;
    }
    private void dfs(TreeNode node){
        cur.append(node.val);
        if(node.left==null&&node.right==null){
            sum+=Integer.parseInt(cur.toString(),2);
            //当前叶子处理完，回溯后返回
            cur.deleteCharAt(cur.length()-1);
            return;
        }
        if(node.left!=null) dfs(node.left);
        if(node.right!=null) dfs(node.right);
        //左右子树都处理完，再删除当前节点值
        cur.deleteCharAt(cur.length()-1);
    }

    //解法二：数值递推
    private int ret=0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ret;
    }
    private void dfs(TreeNode node,int num){
        if(node==null) return;
        //二进制累加当前节点值
        num=num<<1|node.val;
        if(node.left==null&&node.right==null){
            ret+=num;
            return;
        }
        dfs(node.left,num);
        dfs(node.right,num);
    }
}
