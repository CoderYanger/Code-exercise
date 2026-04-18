/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-07
 * Time: 22:14
 */
class Solution {
    //740. 删除并获得点数
    public int deleteAndEarn(int[] nums) {
        //预处理
        int n=10001;
        int[] a=new int[n];
        for(int x:nums) a[x]+=x;
        //dp0[i]:不选nums[i]能获得的最大点数
        int[] dp0=new int[n];
        dp0[0]=0;
        //dp1[i]:选nums[i]能获得的最大点数
        int[] dp1=new int[n];
        dp1[0]=a[0];
        for(int i=1;i<n;i++){
            //不选nums[i],前一个可选可不选
            dp0[i]=Math.max(dp0[i-1],dp1[i-1])+0;
            //选nums[i],前一个必须不选
            dp1[i]=dp0[i-1]+a[i];
        }
        return Math.max(dp0[n-1],dp1[n-1]);
    }

    //滚动数组空间优化
    public int deleteAndEarn(int[] nums) {
        //预处理
        int n=10001;
        int[] a=new int[n];
        for(int x:nums) a[x]+=x;
        int dp0=0,dp1=a[0];
        for(int i=1;i<n;i++){
            int dp=Math.max(dp0+a[i],dp1);
            dp0=dp1;
            dp1=dp;
        }
        return dp1;
    }
}