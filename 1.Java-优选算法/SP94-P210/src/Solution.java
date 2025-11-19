import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-22
 * Time: 19:24
 */
class Solution {
    //210. 课程表 II
    //自己填了几句，注释处是落下的
    public int[] findOrder(int n, int[][] p) {
        int[] in=new int[n];
        Map<Integer, List<Integer>> edges=new HashMap<>();
        //建图
        for(int i=0;i<p.length;i++){
            int a=p[i][0],b=p[i][1];
            if(!edges.containsKey(b)) edges.put(b,new ArrayList<>());
            edges.get(b).add(a);
            in[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int[] ret=new int[n];int k=0;
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        while(!q.isEmpty()){
            int t=q.poll();
            ret[k++]=t;
            for(int a:edges.getOrDefault(t,new ArrayList<>())){
                in[a]--;
                if(in[a]==0) q.add(a);
            }
        }
        for(int x:in) if(x!=0) return new int[0];//有环就返回空数组
        return ret;
    }
}