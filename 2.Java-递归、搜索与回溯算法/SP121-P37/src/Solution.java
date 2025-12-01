/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-08
 * Time: 08:58
 */
class Solution {
    //学完上节（36）有效的数独之后自己写了一遍，注释处是Kimi帮忙改动和补充的
    boolean[][] row,col;
    boolean[][][] grid;
    public void solveSudoku(char[][] board) {
        row=new boolean[9][10];
        col=new boolean[9][10];
        grid=new boolean[3][3][10];
        //初始化已有数字
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int nums=board[i][j]-'0';
                    row[i][nums]=col[j][nums]=grid[i/3][j/3][nums]=true;
                }
            }
        }
        boolean ret=dfs(board);//因为返回值是void，所以不接收或者接收之后不返回都可以
    }
    public boolean dfs(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    //填数
                    for(int k=1;k<10;k++){
                        if(!row[i][k]&&!col[j][k]&&!grid[i/3][j/3][k]){
                            board[i][j]=(char)(k+'0');
                            row[i][k]=col[j][k]=grid[i/3][j/3][k]=true;
                            //已经解完了就直接返回
                            if(dfs(board)) return true;//重点理解
                            //恢复现场
                            board[i][j]='.';
                            row[i][k]=col[j][k]=grid[i/3][j/3][k]=false;
                        }
                    }
                    //1~9都不行
                    return false;//重点理解
                }
            }
        }
        //没有空位
        return true;//重点理解
    }
}