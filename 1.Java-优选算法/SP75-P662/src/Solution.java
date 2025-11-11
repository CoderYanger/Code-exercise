/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-17
 * Time: 14:09
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
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
    //662. 二叉树最大宽度
    //IDEA没有内置Pair，需要自己实现
    class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        List<Pair<TreeNode,Integer>> q=new ArrayList<>();
        //Pair<TreeNode,Integer>这一整体类似数据类型
        q.add(new Pair<TreeNode,Integer>(root,1));int ret=0;
        while(!q.isEmpty()){
            //更新宽度
            Pair<TreeNode,Integer> left=q.get(0);
            Pair<TreeNode,Integer> right=q.get(q.size()-1);
            ret=Math.max(ret,right.getValue()-left.getValue()+1);

            List<Pair<TreeNode,Integer>> tmp=new ArrayList<>();
            for(Pair<TreeNode,Integer> t:q){//从当前层取出每个对
                TreeNode node=t.getKey();
                int index=t.getValue();
                if(node.left!=null)
                    tmp.add(new Pair<TreeNode,Integer>(node.left,2*index));
                if(node.right!=null)
                    tmp.add(new Pair<TreeNode,Integer>(node.right,2*index+1));
            }
            q=tmp;//覆盖
        }
        return ret;
    }
}
