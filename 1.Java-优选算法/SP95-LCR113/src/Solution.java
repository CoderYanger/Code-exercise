import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-22
 * Time: 19:28
 */
class Solution {
    //LCR113. 课程表 II
    public int[] findOrder(int n, int[][] p) {
        //吴小哲的第二种建图方式，我感觉更容易理解，自己一遍就敲过了
        int[] in=new int[n];
        //不同的建图方式
        List<List<Integer>> edges=new ArrayList<>();
        //先给各个节点分配好对应的顺序表
        for(int i=0;i<n;i++) edges.add(new ArrayList<>());
        //把节点放邻接表中
        for(int i=0;i<p.length;i++){
            int a=p[i][0],b=p[i][1];
            edges.get(b).add(a);//此时一定有b,放的是b->a
            in[a]++;
        }
        //拓扑排序
        Queue<Integer> q=new LinkedList<>();
        int[] ret=new int[n];int index=0;
        //先把入度为空的节点放进去
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);//遍历n个节点，看谁入度为0
        while(!q.isEmpty()){
            int t=q.poll();ret[index++]=t;
            for(int a:edges.get(t)){
                in[a]--;
                if(in[a]==0) q.add(a);
            }
        }
        if(index==n) return ret;
        return new int[0];
    }
}