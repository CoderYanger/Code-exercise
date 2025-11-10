/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-17
 * Time: 13:07
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
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
    //103. 二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //在429题基础上增加一条就过了：
        //偶数层数时tmp头插
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null) return ret;
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        int j=0;
        while(!q.isEmpty()){
            j++;
            int sz=q.size();
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode t=q.poll();
                if(j%2==0) tmp.add(0,t.val);
                else tmp.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            ret.add(tmp);
        }
        return ret;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //吴小哲的逆序：Collections.reverse();仅能逆序实现List接口的集合
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null) return ret;
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        int j=0;
        while(!q.isEmpty()){
            j++;
            int sz=q.size();
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode t=q.poll();
                // if(j%2==0) tmp.add(0,t.val);
                // else tmp.add(t.val);
                tmp.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            if(j%2==0) Collections.reverse(tmp);
            ret.add(tmp);
        }
        return ret;
    }
}
