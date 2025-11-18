import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-21
 * Time: 00:07
 */
class Solution {
    //542.01.矩阵
    //自己写的，注释处是AI找到的错误，现在能逻辑上是对的，
    //但由于还是单源bfs，这个是多源最短距离的题
    //所以但凡测试用例长一点就超时了
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,1,-1};
    int m,n;
    boolean[][] vis;
    int[][] dist;
    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;n=mat[0].length;
        dist=new int[m][n];
        //将dist全初始化为-1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=-1;
            }
        }
        List<int[]> st=new ArrayList<>();
        //找到源点0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    st.add(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }
        for(int[] dis:st){
            int a=dis[0],b=dis[1];
            bfs(mat,dist,a,b);
        }
        return dist;
    }
    public void bfs(int[][] mat,int[][] dist,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        vis=new boolean[m][n];
        vis[i][j]=true;
        int step=0;
        while(!q.isEmpty()){
            int sz=q.size();
            step++;
            while(sz-->0){
                int[] t=q.poll();
                int a=t[0],b=t[1];
                for(int k=0;k<4;k++){
                    int x=a+dx[k],y=b+dy[k];
                    if(x>=0&&y>=0&&x<m&&y<n&&!vis[x][y]){
                        if(dist[x][y]==-1||step<dist[x][y])//取更短的
                            dist[x][y]=step;//不是step+1,否则会导致多次累加
                        q.add(new int[]{x,y});
                        vis[x][y]=true;
                    }
                }
            }
        }
    }
    class Solution2 {
        //吴小哲的思路
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{-1,1,0,0};
        int m,n;
        public int[][] updateMatrix(int[][] mat) {
            m=mat.length;n=mat[0].length;
            int[][] dist=new int[m][n];
            //先初始化为－1,顺便把0扔进去
            //为－1时，代表还未搜索到
            Queue<int[]> q=new LinkedList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=-1;
                    if(mat[i][j]==0){//多源bfs主要体现在这里不一样，把所有源点一次性扔进去了（就变成超级源点了）
                        dist[i][j]=0;
                        q.add(new int[]{i,j});
                    }
                }
            }
            while(!q.isEmpty()){
                //之前用step为了更新a,b搜索到的位置
                //但现在不需要了，因为有dist直接对应位置+1就行了
                int[] t=q.poll();
                int a=t[0],b=t[1];
                for(int i=0;i<4;i++){
                    int x=a+dx[i],y=b+dy[i];
                    if(x>=0&&y>=0&&x<m&&y<n&&dist[x][y]==-1){
                        dist[x][y]=dist[a][b]+1;//代表x,y是源点a,b搜索出来的下一层
                        q.add(new int[]{x,y});
                    }
                }
            }
            return dist;
        }
    }
}