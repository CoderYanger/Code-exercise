/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 13:26
 */
class Solution {
    //1582. 二进制矩阵中的特殊位置
    public int numSpecial(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(mat[i][j]==1&&row[i]==1&&col[j]==1) cnt++;
        return cnt;
    }
}
