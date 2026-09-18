/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:23
 */
class Solution {
    //3882. 网格图中最小异或路径
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][][] dp=new boolean[m][n][1024];
        dp[0][0][grid[0][0]]=true;
        //处理第一行
        for(int j=1;j<n;j++){
            for(int x=0;x<1024;x++){
                if(dp[0][j-1][x]){
                    dp[0][j][x^grid[0][j]]=true;
                }
            }
        }
        //处理第一列
        for(int i=1;i<m;i++){
            for(int x=0;x<1024;x++){
                if(dp[i-1][0][x]){
                    dp[i][0][x^grid[i][0]]=true;
                }
            }
        }
        //处理剩余网格
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //从上方(i-1,j)转移而来
                for(int x=0;x<1024;x++){
                    if(dp[i-1][j][x]){
                        dp[i][j][x^grid[i][j]]=true;
                    }
                }
                //从左方(i,j-1)转移而来
                for(int x=0;x<1024;x++){
                    if(dp[i][j-1][x]){
                        dp[i][j][x^grid[i][j]]=true;
                    }
                }
            }
        }
        //遍历终点所有可行异或值，找到最小值
        for(int x=0;x<1024;x++){
            if(dp[m-1][n-1][x]){
                return x;
            }
        }
        //照顾编译器
        return -1;
    }
}