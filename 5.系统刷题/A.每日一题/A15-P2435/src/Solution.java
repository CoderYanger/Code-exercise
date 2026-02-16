import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-26
 * Time: 19:28
 */
public class Solution {
    //2435. 矩阵中和能被 K 整除的路径
    //动态规划写法
    public int numberOfPaths(int[][] grid, int k) {
        int MOD=1000000007;
        int m=grid.length,n=grid[0].length;
        int[][][] dp=new int[m+1][n+1][k];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //初始化起点部分
                if(i==1&&j==1){
                    int value=grid[0][0]%k;
                    dp[i][j][value]=1;
                    continue;
                }
                //处理非起点部分
                int val=grid[i-1][j-1]%k;//当前格子的余数
                for(int r=0;r<k;r++){
                    //确定余数r需要的前一个状态的余数prev
                    int prev=(r-val+k)%k;
                    dp[i][j][r]=(dp[i][j-1][prev]+dp[i-1][j][prev])%MOD;
                }
            }
        }
        return dp[m][n][0];
    }

    //记忆化搜索DFS写法
    private static final int MOD=1_000_000_007;
    public int numberOfPaths2(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[][][] memo=new int[m][n][k];
        //备忘录初始化为-1表示没有计算过
        for(int[][] mat:memo)
            for(int[] row:mat)
                Arrays.fill(row,-1);
        return dfs(m-1,n-1,0,memo,grid,k);
    }
    private int dfs(int i,int j,int r,int[][][] memo,int[][] grid,int k){
        if(i<0||j<0) return 0;//出界
        int val=grid[i][j]%k;
        //确定r需要的prev
        int prev=(r-val+k)%k;
        //起点的情况：prev==0时说明r==val
        if(i==0&&j==0) return prev==0?1:0;
        //先去备忘录找找
        if(memo[i][j][r]!=-1) return memo[i][j][r];
        int ret1=dfs(i-1,j,prev,memo,grid,k);
        int ret2=dfs(i,j-1,prev,memo,grid,k);
        return memo[i][j][r]=(ret1+ret2)%MOD;
    }
}
