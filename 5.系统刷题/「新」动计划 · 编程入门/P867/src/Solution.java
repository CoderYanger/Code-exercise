/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:23
 */
class Solution {
    //867. 转置矩阵
    //0ms击败100.00%
    public int[][] transpose(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] ret=new int[n][m];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                ret[j][i]=matrix[i][j];
        return ret;
    }
}