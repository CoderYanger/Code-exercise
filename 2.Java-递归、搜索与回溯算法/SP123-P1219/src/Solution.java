/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 12:29
 */
class Solution {
    //1219. 黄金矿工
    //自己写的，注释处是豆包帮忙改的错误
    boolean[][] check;
    int m,n;
    int max;
    public int getMaximumGold(int[][] grid) {
        m=grid.length;n=grid[0].length;
        max=0;
        check=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!check[i][j]&&grid[i][j]!=0){
                    check[i][j]=true;
                    //2.调用返回总和的dfs，用结果更新max，删除提前返回的return
                    max=Math.max(max,dfs(grid,i,j));
                    check[i][j]=false;
                }
            }
        }
        return max;
    }
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    //返回值不用boolean，改为int
    public int dfs(int[][] grid,int i,int j){
        int tmp=0;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!check[x][y]&&grid[x][y]!=0){
                check[x][y]=true;
                //递归获取后续路径总和，取最大值
                tmp=Math.max(tmp,dfs(grid,x,y));
                check[x][y]=false;
            }
        }
        //返回格子值+后续路径最大值总和
        return grid[i][j]+tmp;
    }
    //看完吴小哲的代码后自己写了一遍，一遍过
    //dfs不用返回值，path作局部变量递归
    boolean[][] check;
    int m,n;
    int ret;
    public int getMaximumGold(int[][] grid) {
        m=grid.length;n=grid[0].length;
        check=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!check[i][j]&&grid[i][j]!=0){
                    check[i][j]=true;
                    dfs(grid,i,j,grid[i][j]);
                    check[i][j]=false;
                }
            }
        }
        return ret;
    }
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{-1,1,0,0};
    public void dfs(int[][] grid,int i,int j,int path){
        ret=Math.max(ret,path);
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!check[x][y]&&grid[x][y]!=0){
                check[x][y]=true;
                dfs(grid,x,y,grid[x][y]+path);
                check[x][y]=false;
            }
        }
    }
}