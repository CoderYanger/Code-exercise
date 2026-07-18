/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-14
 * Time: 21:00
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
    //100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //先判断结构是否是一样的
        if(p!=null&&q==null||p==null&&q!=null) return false;
        //上述if语句如果没有执行，意味着两个引用同时为空或者同时不为空
        if(p==null&&q==null) return true;
        //都不为空，判断值是否一样
        if(p.val!=q.val) return false;
        //都不为空且值一样
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
