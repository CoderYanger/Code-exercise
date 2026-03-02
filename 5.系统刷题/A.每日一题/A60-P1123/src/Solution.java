/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-11
 * Time: 22:36
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
//1123. 最深叶节点的最近公共祖先
//解法一：递归
class Solution {
    private int maxdepth=-1;//全局最大深度
    private TreeNode ret;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root,0);
        return ret;
    }
    private int dfs(TreeNode node,int depth){
        if(node==null){
            maxdepth=Math.max(maxdepth,depth);
            return depth;
        }
        int leftdepth=dfs(node.left,depth+1);
        int rightdepth=dfs(node.right,depth+1);
        //当leftdepth==rightdepth==maxdepth时，node就是目前最佳答案
        if(leftdepth==rightdepth&&leftdepth==maxdepth) ret=node;
        return Math.max(leftdepth,rightdepth);//往回带最深的深度
    }
}

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
//解法二：自底而上
class Solution {
    //自定义记录类：Java 16+支持record
    //作用：一次返回两个关键信息（最大高度，最近公共祖先）
    private record Pair(int height,TreeNode lca){}
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //调用dfs获取整棵树的高度和对应LCA，直接返回LCA即可
        return dfs(root).lca();
    }
    //后序遍历：计算当前子树的高度+所有最深节点的LCA
    private Pair dfs(TreeNode node){
        //递归出口：空节点，空树高度为0，没有节点，所以LCA为null
        if(node==null) return new Pair(0,null);
        Pair left=dfs(node.left);
        Pair right=dfs(node.right);
        //情况一：左子树最大高度>右子树最大高度
        //说明最深节点在左子树中
        //当前子树高度=左子树最大高度+1，LCA为左子树的LCA
        if(left.height()>right.height())
            return new Pair(left.height()+1,left.lca());
        //情况二：左子树最大高度<右子树最大高度
        if(left.height()<right.height())
            return new Pair(right.height()+1,right.lca());
        //情况三：左右子树最大高度相等
        //说明最深节点同时分布在左右子树中->当前节点就是最近公共祖先
        //当前子树高度=左/右子树高度+1
        return new Pair(left.height()+1,node);
    }
}

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
//解法二的第二种写法，博主觉得比前一种写法更易懂一些
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).getValue();
    }
    private Pair<Integer,TreeNode> dfs(TreeNode node){
        if(node==null) return new Pair<>(0,null);
        Pair<Integer,TreeNode> left=dfs(node.left);
        Pair<Integer,TreeNode> right=dfs(node.right);
        if(left.getKey()>right.getKey())
            return new Pair(left.getKey()+1,left.getValue());
        if(left.getKey()<right.getKey())
            return new Pair(right.getKey()+1,right.getValue());
        return new Pair(left.getKey()+1,node);
    }
}