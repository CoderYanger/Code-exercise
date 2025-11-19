import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-21
 * Time: 10:24
 */
class Solution {
    //1020.飞地的数量
    //自己尝试写的，之前没通过是因为复制粘贴时忘改下标了，思路上整体上还是一遍过的
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public int numEnclaves(int[][] grid) {
        m=grid.length;n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        //先把边界上的1全扔队列里，（超级源点）
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][0]==1){q.add(new int[]{i,0});vis[i][0]=true;}
                if(grid[i][n-1]==1){q.add(new int[]{i,n-1});vis[i][n-1]=true;}
                if(grid[0][j]==1){q.add(new int[]{0,j});vis[0][j]=true;}
                if(grid[m-1][j]==1){q.add(new int[]{m-1,j});vis[m-1][j]=true;}
            }
        }
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                int[] t=q.poll();
                int a=t[0],b=t[1];
                for(int k=0;k<4;k++){
                    int x=a+dx[k],y=b+dy[k];
                    if(x>=0&&y>=0&&x<m&&y<n&&!vis[x][y]&&grid[x][y]==1){
                        q.add(new int[]{x,y});
                        vis[x][y]=true;
                    }
                }
            }
        }
        int ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]==1) ret++;
            }
        }
        return ret;
    }
    //吴小哲的方法，简化了很多
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public int numEnclaves(int[][] grid) {
        m=grid.length;n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        //先把边界上的1全扔队列里，（超级源点）
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // if(grid[i][0]==1){q.add(new int[]{i,0});vis[i][0]=true;}
                // if(grid[i][n-1]==1){q.add(new int[]{i,n-1});vis[i][n-1]=true;}
                // if(grid[0][j]==1){q.add(new int[]{0,j});vis[0][j]=true;}
                // if(grid[m-1][j]==1){q.add(new int[]{m-1,j});vis[m-1][j]=true;}
                if(i==0||i==m-1||j==0||j==n-1){
                    if(grid[i][j]==1){
                        q.add(new int[]{i,j});
                        vis[i][j]=true;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            // int sz=q.size();
            // while(sz-->0){只要遍历到就可以了，不需要这个东西了（源点已经都加进去了）
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                if(x>=0&&y>=0&&x<m&&y<n&&!vis[x][y]&&grid[x][y]==1){
                    q.add(new int[]{x,y});
                    vis[x][y]=true;
                }
            }
            // }
        }
        int ret=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(!vis[i][j]&&grid[i][j]==1) ret++;
        return ret;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] grid=new int[][]{
                {1,0,1,0,1,1,1,0,1,1,0},
                {1,0,0,1,1,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,1,0,1},
                {1,1,0,0,1,1,1,1,1,0,0},
                {0,0,1,0,0,1,0,1,1,0,0},
                {0,1,1,1,0,1,1,0,1,0,0},
                {0,1,0,0,1,1,0,1,0,0,1},
                {1,1,1,0,1,0,0,1,1,0,0},
                {0,1,1,0,0,0,1,0,1,0,0},
                {0,0,0,0,1,0,1,0,1,1,1},
                {0,1,0,0,0,0,1,1,0,1,1}};
        System.out.println(s.numEnclaves(grid));
    }
}