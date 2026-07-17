import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-14
 * Time: 20:59
 */
class Solution {
    //3558. 给边赋权值的方案数 I
    private static int MOD=1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<Integer>[] g=new ArrayList[n+1];
        Arrays.setAll(g, _->new ArrayList<>());
        for(int[] e:edges){
            int x=e[0];
            int y=e[1];
            g[x].add(y);
            g[y].add(x);
        }
        int h=dfs(1,0,g);
        return (int)pow(2,h-1);
    }
    private int dfs(int x,int fa,List<Integer>[] g){
        int h=0;
        for(int y:g[x]){
            if(y!=fa){//不递归到父节点
                h=Math.max(h,dfs(y,x,g)+1);
            }
        }
        return h;
    }
    private long pow(long a,int b){
        long ret=1;
        for(;b>0;b>>=1){
            if((b&1)==1) ret=ret*a%MOD;
            a=a*a%MOD;
        }
        return ret%MOD;
    }
}
