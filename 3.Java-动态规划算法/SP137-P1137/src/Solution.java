/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-11
 * Time: 21:47
 */
class Solution {
    //1137.第n个泰波那契数
    //自己写的，一遍过
    public int tribonacci(int n) {
        //1.创建dp表
        //2.初始化
        //3.填表
        //4.返回结果

        //处理边界情况
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        int[] dp=new int[n+1];
        dp[0]=0;dp[1]=dp[2]=1;
        for(int i=3;i<=n;i++) dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        return dp[n];
    }

    //空间优化版本(滚动数组)
    public int tribonacci(int n) {
        //处理边界情况
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        // int[] dp=new int[n+1];
        // dp[0]=0;dp[1]=dp[2]=1;
        int a=0,b=1,c=1,d=0;
        for(int i=3;i<=n;i++){
            d=a+b+c;
            a=b;b=c;c=d;
        }
        return d;
    }
}