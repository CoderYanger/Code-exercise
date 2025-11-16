import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-19
 * Time: 11:00
 */
class Solution {
    //695. 岛屿的最大面积
    //自己写出来的，注释处是AI找出来的错误
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;n=grid[0].length;
        vis=new boolean[m][n];
        int count=0,ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&vis[i][j]==false){
                    count=Math.max(count,bfs(grid,i,j));
                }
            }
            //ret=Math.max(count,ret);多余了
        }
        return count;
    }
    public int bfs(int[][]grid,int i,int j){
        vis[i][j]=true;
        Queue<int[]> q=new LinkedList<>();
        int count=1;//应该为1而不是0，因为起始地也算
        q.add(new int[]{i,j});//忘记添加元素了
        while(!q.isEmpty()){//忘记加这一步了，导致没有遍历到整个岛屿
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1&&vis[x][y]==false){
                    count++;
                    vis[x][y]=true;
                    q.offer(new int[]{x,y});//用add也行
                }
            }
        }
        return count;
    }
}