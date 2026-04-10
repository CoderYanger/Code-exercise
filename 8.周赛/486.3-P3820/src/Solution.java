import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-25
 * Time: 13:32
 */
class Solution {
    //3820. 树上的勾股距离节点
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        //①构建树的邻接表
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //②计算每个节点到x、y、z的距离
        int[] distx=bfs(adj,x,n);
        int[] disty=bfs(adj,y,n);
        int[] distz=bfs(adj,z,n);
        //③统计满足勾股条件的节点
        int count=0;
        for(int i=0;i<n;i++){
            int a=distx[i];
            int b=disty[i];
            int c=distz[i];
            //排序三个距离
            int[] arr={a,b,c};
            Arrays.sort(arr);
            //判断是否满足条件后累加
            if((long)Math.pow(arr[0],2)+(long)Math.pow(arr[1],2)==(long)Math.pow(arr[2],2)) count++;
        }
        return count;
    }
    private int[] bfs(List<List<Integer>> adj,int start,int n){
        int[] dist=new int[n];
        //初始化为-1，表示还未访问这个节点
        Arrays.fill(dist,-1);
        Queue<Integer> q=new LinkedList<>();
        //起点入队
        q.add(start);
        //起点到自己的距离是0
        dist[start]=0;
        //以start为起点扩散式遍历
        while(!q.isEmpty()){
            int u=q.poll();
            //遍历u的所有邻居节点v
            for(int v:adj.get(u)){
                //如果v还未被访问过
                if(dist[v]==-1){
                    //u到v有一条边，所以距离是u的距离+1
                    dist[v]=dist[u]+1;
                    //把v加入队列继续扩散
                    q.add(v);
                }
            }
        }
        return dist;
    }
}