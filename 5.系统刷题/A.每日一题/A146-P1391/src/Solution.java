/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-09
 * Time: 16:07
 */
class Solution {
    //1391. 检查网格中是否存在有效路径
    private int m,n;
    private int[][] grid;
    private boolean[][] vis;
    //↑↓←→
    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};
    public boolean hasValidPath(int[][] grid) {
        this.grid=grid;
        m=grid.length;n=grid[0].length;
        vis=new boolean[m][n];
        return dfs(0,0);
    }
    private boolean dfs(int i,int j){
        vis[i][j]=true;
        if(i==m-1&&j==n-1) return true;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x>=0&&y>=0&&x<m&&y<n&&!vis[x][y]&&check(grid[i][j],grid[x][y],k)){
                if(dfs(x,y)) return true;
            }
        }
        return false;
    }
    private boolean check(int start,int end,int k){
        if(start==1){
            if(k==2) return end==1||end==4||end==6;
            else if(k==3) return end==1||end==3||end==5;
        }else if(start==2){
            if(k==0) return end==2||end==3||end==4;
            else if(k==1) return end==2||end==5||end==6;
        }else if(start==3){
            if(k==2) return end==1||end==4||end==5||end==6;
            else if(k==1) return end==2||end==5||end==6;
        }else if(start==4){
            if(k==1) return end==1||end==5||end==6;
            else if(k==3) return end==1||end==3||end==5;
        }else if(start==5){
            if(k==0) return end==2||end==3||end==4;
            else if(k==2) return end==1||end==4||end==6;
        }else if(start==6){
            if(k==0) return end==2||end==3||end==4;
            else if(k==3) return end==1||end==3||end==5;
        }
        return false;
    }
}