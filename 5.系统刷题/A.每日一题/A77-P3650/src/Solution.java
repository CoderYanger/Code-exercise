import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-27
 * Time: 19:45
 */
class Solution {
    //3650. 边反转的最小路径总成本
    public int minCost(int n, int[][] edges) {
        //①构建邻接表
        List<int[]>[] g=new ArrayList[n];
        //初始化
        Arrays.setAll(g, _->new ArrayList<>());
        for(int[] e:edges){
            int x=e[0];
            int y=e[1];
            int wt=e[2];//x->y的边权
            g[x].add(new int[]{y,wt});//x->y:权重wt
            g[y].add(new int[]{x,wt*2});//y->x:权重2*wt
        }
        //②dis[x]:表示起点0到节点x的当前最短距离
        int[] dis=new int[n];
        //初始化为0x3f3f3f3f，表示初始不可达
        Arrays.fill(dis,0x3f3f3f3f);
        //③小根堆：存储{起点到节点x的当前距离，节点x}，小根堆保证每次取距离最小的节点
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]-b[0]);
        dis[0]=0;//起点到自身距离为0
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            //取出堆顶元素
            int[] p=pq.poll();
            int disX=p[0];
            //当前处理的节点x
            int x=p[1];
            //如果堆中记录的距离>已找到的最短距离，说明是旧数据，直接跳过
            //原因：同一节点可能多次入堆，只有距离最小的那次有效
            if(disX>dis[x]) continue;
            //首次到达终点n-1时，当前距离就是最短距离，直接返回
            if(x==n-1) return disX;
            //尝试更新邻接节点的最短距离
            for(int[] e:g[x]){
                int y=e[0];//x的邻接节点y
                int wt=e[1];//x到y的边权
                int newDisY=disX+wt;//从0->x->y的新距离
                //如果新距离<原记录的最短距离，说明找到更优路径，更新并入堆
                if(newDisY<dis[y]){
                    dis[y]=newDisY;//更新节点y的更短距离
                    pq.offer(new int[]{newDisY,y});//新状态入堆
                }
            }
        }
        return -1;
    }
}
