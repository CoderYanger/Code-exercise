/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-08
 * Time: 08:14
 */
class Solution {
    //36. 有效的数独
    boolean[][] row,col;
    boolean[][][] grid;
    public boolean isValidSudoku(char[][] board) {
        row=new boolean[9][10];
        col=new boolean[9][10];
        grid=new boolean[3][3][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //判断是否有效
                if(board[i][j]!='.'){
                    int nums=board[i][j]-'0';
                    if(row[i][nums]||col[j][nums]||grid[i/3][j/3][nums]) return false;
                    else row[i][nums]=col[j][nums]=grid[i/3][j/3][nums]=true;
                }
            }
        }
        return true;
    }
}