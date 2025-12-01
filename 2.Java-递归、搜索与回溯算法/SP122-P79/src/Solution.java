/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-08
 * Time: 11:45
 */
class Solution {
    //79. 单词搜索
    //看完吴小哲讲完之后自己敲的，忘写终止条件错了一次
    char[] word;
    boolean[][] vis;
    int m,n;
    public boolean exist(char[][] board, String _word) {
        m=board.length;n=board[0].length;
        vis=new boolean[m][n];
        word=_word.toCharArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&board[i][j]==word[0]){
                    vis[i][j]=true;
                    if(dfs(board,i,j,1)) return true;
                    vis[i][j]=false;
                }
            }
        }
        return false;
    }
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    public boolean dfs(char[][] board,int i,int j,int pos){
        if(pos==word.length) return true;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!vis[x][y]&&board[x][y]==word[pos]){
                vis[x][y]=true;
                if(dfs(board,x,y,pos+1)) return true;
                vis[x][y]=false;
            }
        }
        return false;
    }
}