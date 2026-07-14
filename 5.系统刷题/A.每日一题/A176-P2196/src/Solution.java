/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-09
 * Time: 15:53
 */

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    //2196. 根据描述创建二叉树
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n=descriptions.length;
        Map<Integer,TreeNode> nodes=new HashMap<>(n+1,1);//预分配空间
        Set<Integer> children=new HashSet<>(n,1);
        //建树
        for(int[] d:descriptions){
            int x=d[0],y=d[1];
            nodes.computeIfAbsent(x,_->new TreeNode(x));
            nodes.computeIfAbsent(y,_->new TreeNode(y));
            if(d[2]==1){
                nodes.get(x).left=nodes.get(y);
            }else{
                nodes.get(x).right=nodes.get(y);
            }
            //y不是根节点
            children.add(y);
        }
        for(Map.Entry<Integer,TreeNode> e:nodes.entrySet()){
            if(!children.contains(e.getKey())){
                //找到根节点
                return e.getValue();
            }
        }
        //照顾编译器，题目已保证测试用例合法
        return new TreeNode();
    }


    //优化
    //2196. 根据描述创建二叉树
    public TreeNode createBinaryTree(int[][] descriptions) {
        int root=0;
        Map<Integer,TreeNode> nodes=new HashMap<>(descriptions.length+1,1);//预分配空间

        //建树
        for(int[] d:descriptions){
            int x=d[0],y=d[1];
            if(!nodes.containsKey(x)){
                nodes.put(x,new TreeNode(x));
                root^=x;
            }
            if(!nodes.containsKey(y)){
                nodes.put(y,new TreeNode(y));
                root^=y;
            }
            if(d[2]==1){
                nodes.get(x).left=nodes.get(y);
            }else{
                nodes.get(x).right=nodes.get(y);
            }
            //y不是根节点
            root^=y;
        }
        return nodes.get(root);
    }
    
}