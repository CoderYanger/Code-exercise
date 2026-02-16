import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-28
 * Time: 21:46
 */
class Solution {
    //2872. 可以被 K 整除连通块的最大数目
    private int ret;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        //建图
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<Integer>();
        // 等价的简洁写法（Arrays.setAll）
        //Arrays.setAll(g, _ -> new ArrayList<>());
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(0,-1,graph,values,k);
        return ret;
    }
    //返回子树x的点权和
    private long dfs(int x,int fa,List<Integer>[] graph, int[] values, int k){
        long sum=values[x];
        for(int y:graph[x])
            if(y!=fa)//避免访问父节点
                //加上子树y的点权和
                sum+=dfs(y,x,graph,values,k);
        ret+=sum%k==0?1:0;
        return sum;
    }
}