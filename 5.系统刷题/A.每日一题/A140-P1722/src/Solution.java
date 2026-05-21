import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-04-25
 * Time: 23:18
 */
class Solution {
    //1722. 执行交换操作后的最小汉明距离
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        //构建无向图邻接表：每个下标是一个节点，允许交换的两个下标之间连边
        List<Integer>[] g=new ArrayList[n];
        //初始化
        Arrays.setAll(g, _->new ArrayList<>());
        //遍历所有允许的交换对，给无向图加边
        for(int[] e:allowedSwaps){
            int i=e[0];
            int j=e[1];
            g[i].add(j);
            g[j].add(i);
        }
        //vis数组：标记下标是否已经被访问过，避免重复遍历同一个连通分量
        boolean[] vis=new boolean[n];
        //累计最小汉明距离
        int ret=0;
        //遍历每个下标，找到所有未访问的连通分量
        for(int x=0;x<n;x++){
            if(!vis[x]){
                //统计当前连通分量内，source和target的元素频率差
                Map<Integer,Integer> hash=new HashMap<>();
                //DFS遍历当前连通分量的所有节点，统计元素频率差
                dfs(x,source,target,g,vis,hash);
                //计算当前连通分量贡献的汉明距离
                for(int c:hash.values()) ret+=Math.abs(c);
            }
        }
        return ret/2;
    }
    private void dfs(int x,int[] source,int[] target,List<Integer>[] g,boolean[] vis,Map<Integer,Integer> hash){
        vis[x]=true;
        hash.merge(source[x],1,Integer::sum);
        hash.merge(target[x],-1,Integer::sum);
        //遍历当前节点的所有邻接点
        for(int y:g[x]) if(!vis[y]) dfs(y,source,target,g,vis,hash);
    }
}
