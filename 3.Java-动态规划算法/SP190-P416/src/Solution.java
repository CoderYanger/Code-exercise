/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-27
 * Time: 23:58
 */
class Solution {
    //416. 分割等和子集
    //自己看着算法原理笔记写的，跟吴小哲写的一模一样，就是没注意nums的下标关系而已
    //这是优化前的代码
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums) sum+=x;
        if(sum%2==1) return false;
        int n=nums.length;
        boolean[][] dp=new boolean[n+1][(sum/2)+1];
        //初始化
        for(int i=0;i<=n;i++) dp[i][0]=true;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum/2;j++){
                dp[i][j]=dp[i-1][j];
                //用nums的时候注意下标映射关系
                if(j>=nums[i-1]) dp[i][j]=dp[i][j]||dp[i-1][j-nums[i-1]];
            }
        return dp[n][sum/2];
    }
    public boolean canPartition2(int[] nums) {
        int sum=0;
        for(int x:nums) sum+=x;
        if(sum%2==1) return false;
        int n=nums.length;
        boolean[] dp=new boolean[(sum/2)+1];
        //初始化
        // for(int i=0;i<=n;i++) dp[i][0]=true;
        dp[0]=true;
        for(int i=1;i<=n;i++)
            //如果想把这个循环下的if去掉就直接改成j>=nums[i-1]
            for(int j=sum/2;j>=1;j--){
                // dp[i][j]=dp[i-1][j];
                //用nums的时候注意下标映射关系
                if(j>=nums[i-1]) dp[j]=dp[j]||dp[j-nums[i-1]];
            }
        return dp[sum/2];
    }
}