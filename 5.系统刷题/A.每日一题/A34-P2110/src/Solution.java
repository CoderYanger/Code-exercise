import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-15
 * Time: 12:30
 */
class Solution {
    //2110. 股票平滑下跌阶段的数目
    public long getDescentPeriods(int[] nums) {
        //①状态表示：dp[i]:以i位置结尾的平滑下降阶段的数目
        //②状态转移方程：如果能接在后面就dp[i]+=dp[i-1];
        //③初始化：都初始化为1
        //④填表顺序：从左往右
        //⑤返回值：dp表里的总和
        int n=nums.length;
        long[] dp=new long[n];
        Arrays.fill(dp,1);
        long ret=dp[0];
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]-1) dp[i]+=dp[i-1];
            ret+=dp[i];
        }
        return ret;
    }
}
