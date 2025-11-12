/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-17
 * Time: 19:53
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
    //515. 在每个树行中找最大值
    public List<Integer> largestValues(TreeNode root) {
        //自己写的，注释处是出现的错误
        List<Integer> ret=new ArrayList<>();
        if(root==null) return ret;
        Deque<TreeNode> q=new LinkedList<>();
        int max=Integer.MIN_VALUE;//max初始化最小值，否则出现负数的时候就出错了
        //注意：LinkedList才是Deque的实现类，而非ArrayList
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            Deque<TreeNode> tmp=new LinkedList<>();
            for(int i=0;i<sz;i++){
                TreeNode t=q.poll();
                max=Math.max(max,t.val);
                if(t.left!=null) tmp.add(t.left);
                if(t.right!=null) tmp.add(t.right);
            }
            ret.add(max);max=Integer.MIN_VALUE;
            //max初始化最小值，否则出现负数的时候就出错了
            q=tmp;
        }
        return ret;
    }
}