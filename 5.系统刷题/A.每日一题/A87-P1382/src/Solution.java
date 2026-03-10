/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-11
 * Time: 12:00
 */

import javax.swing.tree.TreeNode;
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
    //1382. 将二叉搜索树变平衡
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums=inorder(root);
        return sorttoBST(nums);
    }
    //中序遍历
    private List<Integer> inorder(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        dfs(ret,root);
        return ret;
    }
    private void dfs(List<Integer> ret,TreeNode node){
        if(node==null) return ;
        dfs(ret,node.left);
        ret.add(node.val);
        dfs(ret,node.right);
    }
    //将有序数组转换成二叉搜索树
    private TreeNode sorttoBST(List<Integer> nums){
        return build(nums,0,nums.size());
    }
    private TreeNode build(List<Integer> nums,int left,int right){
        if(left==right) return null;
        int mid=left+(right-left)/2;
        return new TreeNode(nums.get(mid),build(nums,left,mid),build(nums,mid+1,right));
    }
}
