/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-16
 * Time: 21:02
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
    //145. 二叉树的后序遍历
    //解法一：递归
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    //145. 二叉树的后序遍历
    //解法二：栈
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack();
        TreeNode cur=root;
        //用 prev 指向刚刚被打印过的点，防止死循环
        TreeNode prev=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //由于往左走之后要打印右边
            //所以需要先peek()一下，获取到右边的节点
            //因为弹出去之后，右边的就获取不到了，就丢了
            TreeNode top=stack.peek();
            if(top.right==null||top.right==prev){
                list.add(top.val);
                stack.pop();
                prev=top;
            }else{
                cur=top.right;
            }
        }
        return list;
    }

}
