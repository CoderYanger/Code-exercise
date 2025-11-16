import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-19
 * Time: 18:57
 */
class Solution {
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public int nearestExit(char[][] maze, int[] entrance) {
        m=maze.length;n=maze[0].length;
        vis=new boolean[m][n];
        return bfs(maze,entrance[0],entrance[1]);
    }
    public int bfs(char[][] maze,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;
        int ret=0;//记录遍历到多少层
        while(!q.isEmpty()){
            ret++;//到新的一层++
            int sz=q.size();
            // int[] t=q.poll();
            // int a=t[0],b=t[1];//这个弹出操作应该放在循环里，否则只弹出一次却遍历了四周
            for(int c=0;c<sz;c++){
                int[] t=q.poll();
                int a=t[0],b=t[1];
                for(int k=0;k<4;k++){
                    int x=a+dx[k],y=b+dy[k];
                    if(x>=0&&y>=0&&x<m&&y<n&&vis[x][y]==false&&maze[x][y]=='.'){
                        if((x==0||y==0||x==m-1||y==n-1)&&vis[x][y]==false&&maze[x][y]=='.') return ret;
                        q.add(new int[]{x,y});vis[x][y]=true;
                    }
                }
            }
        }
        return -1;
    }
}