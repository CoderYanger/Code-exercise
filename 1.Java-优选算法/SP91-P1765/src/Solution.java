import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-21
 * Time: 14:56
 */
class Solution {
    //1765. 地图中的最高点
    //自己写的，一遍过，跟之前的好像就是一样的
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    int[][] dist;
    public int[][] highestPeak(int[][] isWater) {
        m=isWater.length;n=isWater[0].length;
        dist=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=-1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    dist[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int i=0;i<4;i++){
                int x=a+dx[i],y=b+dy[i];
                if(x>=0&&y>=0&&x<m&&y<n&&dist[x][y]==-1){
                    q.add(new int[]{x,y});
                    dist[x][y]=dist[a][b]+1;
                }
            }
        }
        return dist;
    }
}