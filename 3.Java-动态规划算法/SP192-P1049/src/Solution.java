/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-28
 * Time: 21:55
 */
class Solution {
    //1049.最后一块石头的重量 II
    //自己看着算法原理写出来的，跟吴小哲写的一样
    //以下是优化前的代码
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length,sum=0;
        for(int x:stones) sum+=x;
        int[][] dp=new int[n+1][sum/2+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum/2;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=stones[i-1])
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
            }
        }
        return sum-2*dp[n][sum/2];
    }
    //以下是优化后的代码
    public int lastStoneWeightII2(int[] stones) {
        int n=stones.length,sum=0;
        for(int x:stones) sum+=x;
        int[] dp=new int[sum/2+1];
        for(int i=1;i<=n;i++){
            for(int j=sum/2;j>=stones[i-1];j--){//修改遍历顺序，将if中条件放进来（空间优化），删掉if
                dp[j]=Math.max(dp[j],dp[j-stones[i-1]]+stones[i-1]);
            }
        }
        return sum-2*dp[sum/2];
    }
}