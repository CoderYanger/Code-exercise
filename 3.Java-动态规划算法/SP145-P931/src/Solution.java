import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-15
 * Time: 13:19
 */
class Solution {
    //931.下降路径最小和
    //看完算法原理后自己写的，主要错在了不知道Math不支持三个参数、Arrays.fill填充时只支持一维数组
    public int minFallingPathSum(int[][] nums) {
        int m=nums.length,n=nums[0].length;
        int[][] dp=new int[m+1][n+2];
        //Arrays.fill只能填充一维数组
        //全初始化为正无穷
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        //第一行改为0
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                //Math不支持三个参数
                dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1])+nums[i-1][j-1];
            }
        }
        //找到最后一行最小值
        int ret=Integer.MAX_VALUE;
        for(int i=0;i<dp[0].length;i++)
            ret=ret>dp[m][i]?dp[m][i]:ret;
        return ret;
    }
}