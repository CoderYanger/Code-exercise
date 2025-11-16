import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-19
 * Time: 10:26
 */
class Solution {
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        //Queue<Character> q=new LinkedList<>();定义在bfs里
        m=grid.length;n=grid[0].length;
        vis=new boolean[m][n];
        int ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&vis[i][j]==false){
                    vis[i][j]=true;
                    ret++;
                    bfs(grid,i,j);
                }
            }
        }
        return ret;
    }
    public void bfs(char[][] grid,int i,int j){
        //Queue<Character> q=new LinkedList<>();
        Queue<int[]> q=new LinkedList<>();
        //q.offer(new char[]{i,j});
        q.add(new int[]{i,j});
        //int a=grid[i]-'0',b=grid[j]-'0';
        while(!q.isEmpty()){
            int[] t=q.poll();
            int a=t[0],b=t[1];//用0表示行，用1表示列，否则在非正方形矩阵会出错
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]=='1'&&vis[x][y]==false){
                    q.add(new int[]{x,y});//少写了这一步
                    vis[x][y]=true;
                }
            }
        }
    }
}