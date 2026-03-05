/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-20
 * Time: 00:28
 */
class Solution {
    //1292. 元素和小于等于阈值的正方形的最大边长
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length,n=mat[0].length;
        int[][] sum=new int[m+1][n+1];
        //初始化二维前缀和数组
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                sum[i+1][j+1]=sum[i+1][j]+sum[i][j+1]-sum[i][j]+mat[i][j];
        int ret=0;
        //遍历原矩阵每个位置作为正方形的左上角(i,j)
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                while(i+ret<m&&j+ret<n&&query(sum,i,j,i+ret,j+ret)<=threshold)
                    ret++;//满足条件，边长+1，继续尝试更大边长
        return ret;
    }
    //返回左上角在(r1,c1)，右下角在(r2,c2)的子矩阵元素和
    private int query(int[][] sum,int r1,int c1,int r2,int c2){
        return sum[r2+1][c2+1]-sum[r2+1][c1]-sum[r1][c2+1]+sum[r1][c1];
    }
}