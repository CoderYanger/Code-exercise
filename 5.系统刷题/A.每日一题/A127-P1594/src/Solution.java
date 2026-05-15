/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:42
 */
class Solution {
    //1594. 矩阵的最大非负积
    private final int MOD=1_000_000_007;
    public int maxProductPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        //f[i][j]:(0,0)到(i,j)的路径最大积
        long[][] f=new long[m][n];
        //g[i][j]:(0,0)到(i,j)的路径最小积
        long[][] g=new long[m][n];
        f[0][0]=g[0][0]=grid[0][0];
        //填第一行：只能从左边转移来
        for(int i=1;i<n;i++){
            if(grid[0][i]>0){
                f[0][i]=f[0][i-1]*grid[0][i];
                g[0][i]=g[0][i-1]*grid[0][i];
            }else{
                f[0][i]=g[0][i-1]*grid[0][i];
                g[0][i]=f[0][i-1]*grid[0][i];
            }
        }
        //填第一列：只能从上边转移来
        for(int j=1;j<m;j++){
            if(grid[j][0]>0){
                f[j][0]=f[j-1][0]*grid[j][0];
                g[j][0]=g[j-1][0]*grid[j][0];
            }else{
                f[j][0]=g[j-1][0]*grid[j][0];
                g[j][0]=f[j-1][0]*grid[j][0];
            }
        }
        //填写其余部分：能从左边或上边转移来
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]>0){
                    f[i][j]=Math.max(f[i][j-1]*grid[i][j],f[i-1][j]*grid[i][j]);
                    g[i][j]=Math.min(g[i][j-1]*grid[i][j],g[i-1][j]*grid[i][j]);
                }else{
                    f[i][j]=Math.max(g[i][j-1]*grid[i][j],g[i-1][j]*grid[i][j]);
                    g[i][j]=Math.min(f[i][j-1]*grid[i][j],f[i-1][j]*grid[i][j]);
                }
            }
        }
        return f[m-1][n-1]<0?-1:(int)(f[m-1][n-1]%MOD);
    }
}
