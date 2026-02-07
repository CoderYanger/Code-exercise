/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-27
 * Time: 12:08
 */

import javax.swing.tree.TreeNode;
import java.util.*;

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
    //2476. 二叉搜索树最近节点查询
    //解法一：二分查找+层序遍历
    List<Integer> list=new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ret=new ArrayList<>();
        //将树中的节点全部提取出来
        bfs(root);
        Collections.sort(list);
        for(int x:queries){
            List<Integer> tmp=new ArrayList<>();
            //求最右端点模型找mini
            int left=0,right=list.size()-1;
            while(left<right){
                int mid=left+(right-left+1)/2;
                if(list.get(mid)>x) right=mid-1;
                else left=mid;
            }
            //如果所有数都比x大，就添加-1进去
            if(list.get(left)>x) tmp.add(-1);
            else tmp.add(list.get(left));
            //求最左端点模型找maxi
            left=0;right=list.size()-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(list.get(mid)<x) left=mid+1;
                else right=mid;
            }
            //如果所有数都比x小，就添加-1进去
            if(list.get(left)<x) tmp.add(-1);
            else tmp.add(list.get(left));
            ret.add(tmp);
        }
        return ret;
    }
    //层序遍历提取节点值
    private void bfs(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            list.add(cur.val);
            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);
        }
    }

    //解法二：二分查找+中序遍历
    List<Integer> list=new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ret=new ArrayList<>();
        //将树中的节点全部提取出来
        dfs(root);
        Collections.sort(list);
        for(int x:queries){
            List<Integer> tmp=new ArrayList<>();
            //求最右端点模型找mini
            int left=0,right=list.size()-1;
            while(left<right){
                int mid=left+(right-left+1)/2;
                if(list.get(mid)>x) right=mid-1;
                else left=mid;
            }
            //如果所有数都比x大，就添加-1进去
            if(list.get(left)>x) tmp.add(-1);
            else tmp.add(list.get(left));
            //求最左端点模型找maxi
            left=0;right=list.size()-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(list.get(mid)<x) left=mid+1;
                else right=mid;
            }
            //如果所有数都比x小，就添加-1进去
            if(list.get(left)<x) tmp.add(-1);
            else tmp.add(list.get(left));
            ret.add(tmp);
        }
        return ret;
    }
    //中序遍历提取节点值
    private void dfs(TreeNode node){
        if(node==null) return ;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
