/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-21
 * Time: 13:41
 */
class Solution {
    //3212. 统计 X 和 Y 频数相等的子矩阵数量
    //解法一：二维前缀和
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] sumX=new int[m+1][n+1];
        int[][] sumY=new int[m+1][n+1];
        int cnt=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sumX[i][j]=sumX[i-1][j]+sumX[i][j-1]-sumX[i-1][j-1]+(grid[i-1][j-1]=='X'?1:0);
                sumY[i][j]=sumY[i-1][j]+sumY[i][j-1]-sumY[i-1][j-1]+(grid[i-1][j-1]=='Y'?1:0);
                if(sumX[i][j]>0&&sumX[i][j]==sumY[i][j]) cnt++;
            }
        }
        return cnt;
    }

    //解法二：维护每列字符个数
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid[0].length;
        int[] colsumX=new int[n];
        int[] colsumY=new int[n];
        int cnt=0;
        for(char[] row:grid){
            int sumX=0,sumY=0;
            for(int i=0;i<n;i++){
                colsumX[i]+=(row[i]=='X'?1:0);
                colsumY[i]+=(row[i]=='Y'?1:0);
                sumX+=colsumX[i];
                sumY+=colsumY[i];
                if(sumX>0&&sumX==sumY) cnt++;
            }
        }
        return cnt;
    }

    //解法二优化：维护每列字符个数
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid[0].length;
        int[][] colsum=new int[n][2];
        int cnt=0;
        for(char[] row:grid){
            int sumX=0,sumY=0;
            for(int i=0;i<n;i++){
                if(row[i]!='.') colsum[i][row[i]&1]++;
                sumX+=colsum[i][0];
                sumY+=colsum[i][1];
                if(sumX>0&&sumX==sumY) cnt++;
            }
        }
        return cnt;
    }

}
