/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-10
 * Time: 20:19
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    //1161. 最大层内元素和
    public int maxLevelSum(TreeNode root) {
        //一次层序遍历即可
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int sum=0;
            //计算一下当前层多少个数据
            int size=q.size();
            while(size!=0){
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                size--;
            }
            //加入当前层元素和
            list.add(sum);
        }
        //找每层元素和的最大值
        int max=-0x3f3f3f3f;
        for(int x:list) max=Math.max(max,x);
        for(int i=0;i<list.size();i++) if(list.get(i)==max) return i+1;
        //照顾编译器
        return -1;
    }
}