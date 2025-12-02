/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 19:32
 */
class Solution {
    //自己写的，两次通过，第一次没通过是因为忘记了边界也可能连通O
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public void solve(char[][] board) {
        m=board.length;n=board[0].length;
        vis=new boolean[m][n];
        //先将边界的O转换成无关字符，防止干扰
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||j==0||i==m-1||j==n-1)&&board[i][j]=='O'){
                    board[i][j]='.';
                    vis[i][j]=true;
                    dfs(board,i,j,'.');
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&board[i][j]=='O'){
                    vis[i][j]=true;
                    board[i][j]='X';
                    dfs(board,i,j,'X');
                }
            }
        }
        //复原
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.') board[i][j]='O';
            }
        }
    }
    public void dfs(char[][] board,int i,int j,char mark){
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!vis[x][y]&&board[x][y]=='O'){
                vis[x][y]=true;
                board[x][y]=mark;
                dfs(board,x,y,mark);
            }
        }
    }

    //吴小哲的解法，其中处理边界的时候分开弄的，我感觉不如我这个简单还直观，其余都比我这个好些
    //但代码逻辑是一样的
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    //boolean[][] vis;
    public void solve(char[][] board) {
        m=board.length;n=board[0].length;
        //vis=new boolean[m][n];
        //先将边界的O转换成无关字符，防止干扰
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||j==0||i==m-1||j==n-1)&&board[i][j]=='O'){
                    board[i][j]='.';
                    //vis[i][j]=true;
                    dfs(board,i,j);
                }
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(!vis[i][j]&&board[i][j]=='O'){
        //             //vis[i][j]=true;
        //             board[i][j]='X';
        //             dfs(board,i,j,'X');
        //         }
        //     }
        // }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.') board[i][j]='O';//复原
                else if(board[i][j]=='O') board[i][j]='X';//转化
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&board[x][y]=='O'){
                //vis[x][y]=true;
                board[x][y]='.';
                dfs(board,x,y);
            }
        }
    }
}