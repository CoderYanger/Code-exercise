/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-12
 * Time: 22:56
 */
class Solution {
    //面试题08.01.三步问题
    public int waysToStep(int n){
        //1.创建dp表
        //2.初始化
        //3.填表
        //4.返回值
        int MOD=(int)1e9+7;//默认double型
        if(n==1||n==2) return n;
        if(n==3) return 4;
        int[] dp=new int[n+1];
        dp[1]=1;dp[2]=2;dp[3]=4;
        for(int i=4;i<=n;i++)
            //每次加法都要取模
            dp[i]=((dp[i-1]+dp[i-2])%MOD+dp[i-3])%MOD;
        return dp[n];
    }
}