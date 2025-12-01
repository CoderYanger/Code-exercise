/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 12:36
 */
class Solution {
    //自己写的，注释处是豆包找的错误：到2就返回+绕过障碍－1
    boolean[][] check;
    int m,n;
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int ret,step;
    public int uniquePathsIII(int[][] grid) {
        m=grid.length;n=grid[0].length;
        check=new boolean[m][n];
        //统计一共需要走的步数
        for(int[] tmp:grid){
            for(int x:tmp)
                if(x==0) step++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    check[i][j]=true;
                    dfs(grid,i,j,0);
                    check[i][j]=false;
                }
            }
        }
        return ret;
    }
    public void dfs(int[][] grid,int i,int j,int path){
        if(grid[i][j]==2){
            if(path==step+1) ret++;
            return;//无论是否合法，到终点都要返回
        }
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            //要绕过障碍-1
            if(x<m&&y<n&&x>=0&&y>=0&&!check[x][y]&&grid[x][y]!=-1){
                check[x][y]=true;
                dfs(grid,x,y,path+1);
                check[x][y]=false;
            }
        }
    }
    //吴小哲的解法：开始统计step的时候顺便标记起点，后面就不用两层for循环了
    boolean[][] check;
    int m,n;
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int ret,step;
    public int uniquePathsIII(int[][] grid) {
        m=grid.length;n=grid[0].length;
        check=new boolean[m][n];
        //统计一共需要走的步数
        int bx=0,by=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) step++;
                    //标记起始位置
                else if(grid[i][j]==1){bx=i;by=j;}
            }
        }
        step+=2;//起点和终点的
        check[bx][by]=true;
        dfs(grid,bx,by,1);
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j]==1){
        //             check[i][j]=true;
        //             dfs(grid,i,j,0);
        //             check[i][j]=false;
        //         }
        //     }
        // }
        return ret;
    }
    public void dfs(int[][] grid,int i,int j,int path){
        if(grid[i][j]==2){
            if(path==step) ret++;
            return;//无论是否合法，到终点都要返回
        }
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            //要绕过障碍-1
            if(x<m&&y<n&&x>=0&&y>=0&&!check[x][y]&&grid[x][y]!=-1){
                check[x][y]=true;
                dfs(grid,x,y,path+1);
                check[x][y]=false;
            }
        }
    }
}