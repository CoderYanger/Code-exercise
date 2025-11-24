/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-24
 * Time: 09:18
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
    //自己写的时候忘记了中序遍历是有序的，写的啥也不是，后来找豆包才想起这个问题
    //于是按着自己的思路写了一下，除了Long.MIN_VALUE其他都是对的
    long prev=Long.MIN_VALUE;//对应修改为Long.MIN_VALUE
    public boolean isValidBST(TreeNode root) {
        //中序遍历
        if(root==null) return true;
        //笑死了，原来我自己写的本来就是带剪枝的，遇到不合法的直接返回就是剪枝
        if(!isValidBST(root.left)) return false;
        if(root.val>prev) prev=root.val;
        else return false;
        if(!isValidBST(root.right)) return false;
        return true;
    }
}