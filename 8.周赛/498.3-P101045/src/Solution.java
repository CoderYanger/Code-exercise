import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-04-19
 * Time: 13:50
 */
//101045. 多源洪水灌溉
//一开始的错误代码
class Combine{
    int[] xy;
    int color;
    public Combine(int[] xy,int color){
        this.xy=xy;
        this.color=color;
    }
}
class Solution {
    private final int[] dx={0,0,1,-1};
    private final int[] dy={1,-1,0,0};
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] mat=new int[n][m];
        Queue<Combine> q=new LinkedList<>();
        for(int[] t:sources) q.add(new int[]{t[0],t[1]},t[2]);
        while(!q.isEmpty()){
            Combine t=q.poll();
            int a=t.xy[0];
            int b=t.xy[1];
            int color=t.color;
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                if(x>=0&&x<n&&y>=0&&y<m&&mat[x][y]<color&&!check(mat)){
                    q.add(new int[]{x,y},color);
                    mat[x][y]=color;
                }
            }
        }
        return mat;
    }
    //判断是否被填满
    private boolean check(int[][] mat){
        for(int[] m:mat) for(int x:m) if(x==0) return false;
        return true;
    }
}

//正确代码
class Combine{
    int[] xy;
    int color;
    public Combine(int[] xy,int color){
        this.xy=xy;
        this.color=color;
    }
}
class Solution {
    private final int[] dx={0,0,1,-1};
    private final int[] dy={1,-1,0,0};
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] mat=new int[n][m];
        Queue<Combine> q=new LinkedList<>();
        for(int[] t:sources){
            mat[t[0]][t[1]]=t[2];
            q.add(new Combine(new int[]{t[0],t[1]},t[2]));
        }
        while(!q.isEmpty()){
            //按层处理，按时间走
            int size=q.size();
            Map<Integer,Integer> hash=new HashMap<>();
            //遍历当前层所有节点，收集所有待扩散的位置，保留最大颜色
            for(int i=0;i<size;i++){
                Combine t=q.poll();
                int a=t.xy[0];
                int b=t.xy[1];
                int color=t.color;
                for(int k=0;k<4;k++){
                    int x=a+dx[k],y=b+dy[k];
                    if(x>=0&&x<n&&y>=0&&y<m&&mat[x][y]==0){
                        int key=x*m+y;
                        hash.put(key,Math.max(hash.getOrDefault(key,0),color));
                    }
                }
            }
            //统一染色当前时间的格子，加入下一队列
            for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
                int key=entry.getKey();
                int x=key/m;
                int y=key%m;
                int color=entry.getValue();
                mat[x][y]=color;
                q.add(new Combine(new int[]{x,y},color));
            }
        }
        return mat;
    }
}