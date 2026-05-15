/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:43
 */
//解法一：暴力枚举（解决了溢出问题，但却导致了超时）
import java.math.BigInteger;
class Solution {
    //2906. 构造乘积矩阵
    private final BigInteger MOD=BigInteger.valueOf(12345);
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        BigInteger s=BigInteger.valueOf(1);
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) s=s.multiply(BigInteger.valueOf(grid[i][j]));
        int[][] ret=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                BigInteger t=s;
                ret[i][j]=t.divide(BigInteger.valueOf(grid[i][j])).mod(MOD).intValue();
            }
        }
        return ret;
    }

    //解法二：前后缀分解-一维解法
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD=12345;
        int m=grid.length,n=grid[0].length;
        //二维转一维
        int[] a=new int[m*n];
        int index=0;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) a[index++]=grid[i][j];
        long[] pre=new long[m*n];
        pre[0]=1;
        long[] suf=new long[m*n];
        suf[m*n-1]=1;
        for(int i=1;i<m*n;i++) pre[i]=1L*pre[i-1]*a[i-1]%MOD;
        for(int i=m*n-2;i>=0;i--) suf[i]=1L*suf[i+1]*a[i+1]%MOD;
        //一维转二维
        int[][] ret=new int[m][n];
        int row=0;
        for(int i=0;i<m*n;i++){
            ret[row][i%n]=(int)(pre[i]*suf[i]%MOD);
            if((i+1)%n==0) row++;
        }
        return ret;
    }

    //解法二：前后缀分解-二维解法
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD=12345;
        int m=grid.length,n=grid[0].length;
        int[][] ret=new int[m][n];
        long pre=1;//前缀积
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ret[i][j]=(int)pre;
                pre=pre*grid[i][j]%MOD;
            }
        }
        long suf=1;//后缀积
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                ret[i][j]=(int)(ret[i][j]*suf%MOD);
                suf=suf*grid[i][j]%MOD;
            }
        }
        return ret;
    }
    
}
