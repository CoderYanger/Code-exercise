import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-09-01
 * Time: 20:08
 */
class Solution {
    //3310. 移除可疑的方法
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Integer>[] g=new ArrayList[n];
        Arrays.setAll(g, _->new ArrayList<>());
        //建图
        for(int[] e:invocations) g[e[0]].add(e[1]);

        //DFS标记所有可疑方法
        boolean[] isSuspicious=new boolean[n];
        dfs(k,g,isSuspicious);

        //检查是否有 非可疑方法→可疑方法 的边
        for(int[] e:invocations){
            //!isSuspicious[e[0]]：非可疑方法
            //isSuspicious[e[1]]：可疑方法
            if(!isSuspicious[e[0]]&&isSuspicious[e[1]]){
                //无法移除可疑方法，全部返回
                List<Integer> ret=new ArrayList<>();
                for(int i=0;i<n;i++) ret.add(i);
                return ret;
            }
        }

        //移除所有可疑方法
        List<Integer> ret=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(!isSuspicious[i])
                ret.add(i);
        return ret;
    }

    private void dfs(int k,List<Integer>[] g,boolean[] isSuspicious){
        //以可疑的 k 为起始 DFS
        isSuspicious[k]=true;
        for(int x:g[k])
            if(!isSuspicious[x])//避免无限递归
                dfs(x,g,isSuspicious);
    }
}
