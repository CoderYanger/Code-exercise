import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-19
 * Time: 15:55
 */
class Solution {
    //自己写的，注释处是找AI后修改过来的
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    public void solve(char[][] board) {
        m=board.length;n=board[0].length;
        if(board==null||m==0||n==0) return;
        //这里一定要外部和内部分开写，不能边遍历边改，否则就乱了，外部刚bfs处理完就被内部改了
        //先处理外部
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||j==0||i==m-1||j==n-1)&&board[i][j]=='O')
                    bfsout(board,i,j);
            }
        }
        //再处理内部
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0&&j!=0&&i!=m-1&&j!=n-1&&board[i][j]=='O')
                    bfsin(board,i,j);
            }
        }
        //将无关字符还原
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.') board[i][j]='O';
            }
        }
    }
    public void bfsin(char[][] board ,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        board[i][j]='X';//自己本身也要变成X
        while(!q.isEmpty()){
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                //只在中间部分检索
                if(x>=1&&x<m-1&&y>=1&&y<n-1&&board[x][y]=='O'){
                    board[x][y]='X';
                    q.add(new int[]{x,y});
                }
            }
        }
    }
    public void bfsout(char[][] board ,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        board[i][j]='.';//自己本身也要变成.
        while(!q.isEmpty()){
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                //从外部检索，凡是与外圈相连的全改为无关字符
                if(x>=0&&x<m&&y>=0&&y<n&&board[x][y]=='O'){
                    board[x][y]='.';
                    q.add(new int[]{x,y});
                }
            }
        }
    }
    //按照吴小哲的思路自己写的，感觉更能接受
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    public void solve(char[][] board) {
        m=board.length;n=board[0].length;
        //先把边界扩展出来的O全变成.
        //先处理边界行
        for(int i=0;i<n;i++){//这里是n不是m，一开始搞反了
            if(board[0][i]=='O') bfs(board,0,i);
            if(board[m-1][i]=='O') bfs(board,m-1,i);
        }
        //再处理边界列
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') bfs(board,i,0);
            if(board[i][n-1]=='O') bfs(board,i,n-1);
        }
        //还原，把所有的O全变成X，把所有的.全变成O
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='.') board[i][j]='O';
            }
        }
    }
    //用bfs将边界的O改成.
    public void bfs(char[][] board,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        board[i][j]='.';
        while(!q.isEmpty()){
            int[] t=q.poll();
            int a=t[0],b=t[1];
            for(int k=0;k<4;k++){
                int x=a+dx[k],y=b+dy[k];
                if(x>=0&&y>=0&&x<m&&y<n&&board[x][y]=='O') {
                    board[x][y]='.';
                    q.add(new int[]{x,y});
                }
            }
        }
    }
}