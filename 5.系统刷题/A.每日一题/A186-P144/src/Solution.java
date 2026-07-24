/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-16
 * Time: 21:01
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
    //144. 二叉树的前序遍历
    //解法一：递归
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    //144. 二叉树的前序遍历
    //解法二：栈
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return list;
        //栈的作用：暂存待处理右子树的父节点
        Stack<TreeNode> stack=new Stack();
        TreeNode cur=root;
        //不加cur!=null一开始进不去
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                //不空就入栈，暂存
                stack.push(cur);
                list.add(cur.val);
                //接着前序遍历，往左走
                cur=cur.left;
            }
            //左边空了，就把这个元素弹出来放进top里
            TreeNode top=stack.pop();
            //再去看这个元素的右边
            cur=top.right;
        }
        return list;
    }
}
