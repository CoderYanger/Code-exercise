/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:45
 */
class Solution {
    //3546. 等和矩阵分割 I
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length,n=grid[0].length;

        //每行的和
        long[] row=new long[m];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) row[i]+=grid[i][j];
        //计算行的前缀和
        long[] rowsum=new long[m];
        rowsum[0]=row[0];
        for(int i=1;i<m;i++) rowsum[i]=rowsum[i-1]+row[i];
        //检查水平线
        for(int i=0;i<m;i++) if(rowsum[i]==rowsum[m-1]-rowsum[i]) return true;

        //每列的和
        long[] col=new long[n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) col[j]+=grid[i][j];
        //计算行的前缀和
        long[] colsum=new long[n];
        colsum[0]=col[0];
        for(int i=1;i<n;i++) colsum[i]=colsum[i-1]+col[i];
        //检查垂直线
        for(int i=0;i<n;i++) if(colsum[i]==colsum[n-1]-colsum[i]) return true;
        return false;
    }
}
