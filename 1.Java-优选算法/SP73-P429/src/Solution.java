import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-16
 * Time: 23:36
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null) return ret;
        Deque<Node> q=new LinkedList<>();
        q.add(root);//先让根节点这一个入队
        while(!q.isEmpty()){
            int sz=q.size();//统计本层节点的个数
            List<Integer> tmp=new ArrayList<>();//统计本层节点的信息
            for(int i=0;i<sz;i++){
                Node t=q.poll();
                tmp.add(t.val);
                for(Node child:t.children){//让孩子入队
                    if(child!=null) q.add(child);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}