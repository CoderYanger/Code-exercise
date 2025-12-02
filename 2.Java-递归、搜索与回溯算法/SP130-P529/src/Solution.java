/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 18:04
 */
class Solution {
    //529. 扫雷游戏
    //自己写了之后借助AI找的错误，注释处代码是当时自己写的错误代码
    int[] dx=new int[]{1,-1,0,0,1,1,-1,-1};
    int[] dy=new int[]{0,0,1,-1,1,-1,1,-1};
    int m,n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m=board.length;n=board[0].length;
        //上来就踩到雷
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        dfs(board,click[0],click[1]);
        return board;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=m||j>=n||board[i][j]!='E') return;
        board[i][j]='B';
        int count=countmine(board,i,j);
        if(count!=0){
            board[i][j]=(char)(count+'0');
            return;
        }
        for(int k=0;k<8;k++){
            int x=i+dx[k],y=j+dy[k];
            dfs(board,x,y);//修改：无需提前判断，直接交给子递归，下面这个代码会错误的将B改为E
            //原因：发生越界的时候直接返回，导致还停留在E的状态
            //if(x<m&&y<n&&x>=0&&y>=0&&board[x][y]=='E'){
            //    board[x][y]='B';
            //    dfs(board,x,y);
            //    //board[x][y]='B';
            //}
        }
        //board[i][j]=(dfs(board,i,j)==0?'B':(dfs(board,i,j)+'0'));
        //if(board[i][j]=='B'){
        //    int count=0;
        //    for(int k=0;k<8;k++){
        //        int x=i+dx[k],y=j+dy[k];
        //        if(board[x][y]=='M'){
        //            count++;
        //            return count+'0';
        //        }
        //        if(dfs(board,x,y)!='B'||dfs(board,x,y)!='E') return dfs(board,x,y);
        //
        //    }
        //}else return board[i][j]-'0';
    }
    public int countmine(char[][] board,int i,int j){
        int count=0;
        for(int k=0;k<8;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&board[x][y]=='M'){
                count++;
            }
        }
        return count;
    }

    //吴小哲的解法，跟我那个一样，但这个 看起来更简单些
    int[] dx=new int[]{0,0,1,-1,1,1,-1,-1};
    int[] dy=new int[]{1,-1,0,0,1,-1,1,-1};
    int m,n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m=board.length;n=board[0].length;
        int xx=click[0],yy=click[1];
        if(board[xx][yy]=='M'){
            board[xx][yy]='X';
            return board;
        }
        dfs(board,xx,yy);
        return board;
    }
    public void dfs(char[][] board,int i,int j){
        //统计周围地雷的个数
        int count=0;
        for(int k=0;k<8;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x>=0&&y>=0&&x<m&&y<n&&board[x][y]=='M') count++;
        }
        if(count!=0){
            board[i][j]=(char)(count+'0');
            return;
        }else{
            board[i][j]='B';
            for(int k=0;k<8;k++){
                int x=i+dx[k],y=j+dy[k];
                if(x>=0&&y>=0&&x<m&&y<n&&board[x][y]=='E') dfs(board,x,y);
            }
        }
    }
}