/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 17:50
 */
class Solution {
    //自己写的dfs，一遍过
    //吴小哲跟我写的大体一样
    int m,n;
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    boolean[][] vis;
    int ret;
    public int numIslands(char[][] grid) {
        m=grid.length;n=grid[0].length;
        vis=new boolean[m][n];
        ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    ret++;
                    vis[i][j]=true;
                    dfs(grid,i,j);
                }
            }
        }
        return ret;
    }
    public void dfs(char[][] grid,int i,int j){
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!vis[x][y]&&grid[x][y]=='1'){ vis[x][y]=true;dfs(grid,x,y);}
        }
    }
}