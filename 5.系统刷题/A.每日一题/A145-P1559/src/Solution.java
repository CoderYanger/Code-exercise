/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-09
 * Time: 16:06
 */
class Solution {
    //1559. 二维网格图中探测环
    private final int[] dx={0,0,1,-1};
    private final int[] dy={1,-1,0,0};
    private boolean[][] vis;
    private int m,n;
    public boolean containsCycle(char[][] grid) {
        m=grid.length;n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(i,j,-1,-1,grid)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,int fx,int fy,char[][] grid){
        vis[i][j]=true;
        char cur=grid[i][j];
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x>=0&&y>=0&&x<m&y<n){
                //跳过起始节点，避免回退
                if(x==fx&&y==fy) continue;
                //必须是相同字符
                if(grid[x][y]!=cur) continue;
                if(vis[x][y]) return true;
                //邻居未访问，继续dfs
                if(dfs(x,y,i,j,grid)) return true;
            }
        }
        return false;
    }
}
