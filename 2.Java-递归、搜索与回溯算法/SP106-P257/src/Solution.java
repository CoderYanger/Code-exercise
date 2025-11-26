/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-24
 * Time: 15:00
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
    //257. 二叉树的所有路径
    //自己写了一遍，错误的地方注释了，对比吴小哲之后才发现的错误
    List<String> ret=new ArrayList<>();
    StringBuffer path=new StringBuffer("");
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,path);
        return ret;
    }
    //Boolean count=false;//判断是否第一次拼接
    //count错误原因：需要的是每条路径仅一次，而非全局仅一次
    public void dfs(TreeNode root,StringBuffer _path){
        StringBuffer path=new StringBuffer(_path);
        if(root==null) return;
        path.append(root.val);//放外面
        if(root.left==null&&root.right==null){
            // if(!count){path.append(root.val);count=true;}
            // else {path.append("->"+root.val);root=null;}
            ret.add(path.toString());return;
        }
        path.append("->");
        if(root.left!=null)dfs(root.left,path);
        if(root.right!=null)dfs(root.right,path);
    }
}