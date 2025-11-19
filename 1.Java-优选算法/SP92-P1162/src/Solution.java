import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-21
 * Time: 15:48
 */
class Solution {
    //1162. 地图分析
    //全是自己写的，一遍过，对比之前只是小部分更改，我写的都对了
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    int[][] dist;
    public int maxDistance(int[][] grid) {
        m=grid.length;n=grid[0].length;
        dist=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=-1;
            }
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&dist[i][j]==-1){
                    dist[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        //全是海洋，返回-1
        if(q.size()==0) return -1;
        while(!q.isEmpty()){
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                if(x>=0&&y>=0&&x<m&&y<n&&dist[x][y]==-1&&grid[x][y]==0){
                    q.add(new int[]{x,y});
                    dist[x][y]=dist[a][b]+1;
                }
            }
        }
        int maxdis=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxdis=Math.max(maxdis,dist[i][j]);
            }
        }
        return maxdis==0?-1:maxdis;
    }
}