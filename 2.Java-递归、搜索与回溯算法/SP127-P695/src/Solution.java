/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 18:54
 */
class Solution {
    //自己写的，一遍通过，芜湖！！！
    //吴小哲写的跟我大体一样，无非就是用count代替dfs的返回值了
    int m,n;
    boolean[][] vis;
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    int ret;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;n=grid[0].length;
        vis=new boolean[m][n];
        ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    vis[i][j]=true;
                    ret=Math.max(ret,dfs(grid,i,j));
                }
            }
        }
        return ret;
    }
    public int dfs(int[][] grid,int i,int j){
        int path=0;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!vis[x][y]&&grid[x][y]==1){
                vis[x][y]=true;
                path+=dfs(grid,x,y);
            }
        }
        return path+grid[i][j];
    }
}