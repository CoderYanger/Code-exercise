/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-23
 * Time: 22:36
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
    //前面注释掉的一堆代码是自己看着思路写的，发现不对，看完吴小哲的讲解之后，自己又写了一遍

    // public int sumNumbers(TreeNode root) {
    //     return dfs(root,root.val);
    // }
    // public int dfs(TreeNode root,int sum){
    //     if(root==null) return sum;
    //     int left=dfs(root.left,sum);sum=sum*10+left;
    //     int right=dfs(root.right,sum);sum=sum*10+right;
    //     return left+right;
    // }
    public int sumNumbers(TreeNode root){
        return dfs(root,0);//刚开始前驱和为0
    }
    public int dfs(TreeNode root,int presum){
        presum=presum*10+root.val;
        //递归出口，看是不是叶子节点
        if(root.left==null&&root.right==null) return presum;
        int ret=0;//计算当前节点计算得到的值
        if(root.left!=null) ret+=dfs(root.left,presum);
        if(root.right!=null) ret+=dfs(root.right,presum);
        return ret;
    }
}