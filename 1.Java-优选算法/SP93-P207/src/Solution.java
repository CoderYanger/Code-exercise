import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-22
 * Time: 19:22
 */
class Solution {
    //207. 课程表
    public boolean canFinish(int n, int[][] p) {
        //n是节点数，p是两节点间的边
        int[] in=new int[n];//计算节点入度
        Map<Integer, List<Integer>> edges=new HashMap<>();//邻接表放入节点
        //建图
        for(int i=0;i<p.length;i++){
            int a=p[i][0],b=p[i][1];
            if(!edges.containsKey(b)) edges.put(b,new ArrayList<>());
            //b第一次进来的时候没有它，需要为它建立空顺序表
            edges.get(b).add(a);
            in[a]++;
        }
        //拓扑排序
        Queue<Integer> q=new LinkedList<>();
        //1.先放入入度为0的节点
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        //2.bfs
        while(!q.isEmpty()){
            int t=q.poll();
            //切掉t所连接的边
            for(int a:edges.getOrDefault(t,new ArrayList<>())){
                in[a]--;//主要处理是入度为0的节点，所以没必要看到底切的哪条边
                if(in[a]==0) q.add(a);
            }
        }
        //判断是否有环
        for(int x:in) if(x!=0) return false;
        return true;
    }
}