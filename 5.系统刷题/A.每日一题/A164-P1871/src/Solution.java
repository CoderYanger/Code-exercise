/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-25
 * Time: 18:04
 */
class Solution {
    //1871. 跳跃游戏 VII
    //解法一：动态规划+暴力枚举
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        if(s.charAt(n-1)=='1') return false;
        //dp[i]：记录当前位置能否到达下标s.length-1处
        boolean[] dp=new boolean[n];
        dp[n-1]=true;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='1') continue;//当前位置是'1'，直接跳过
            for(int j=i+minJump;j<=Math.min(i+maxJump,n-1);j++){
                if(dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }

    //1871. 跳跃游戏 VII
    //解法一：动态规划+暴力枚举
    //优化
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        int[] dp=new int[n];
        //dp的前缀和
        int[] sum=new int[n+1];
        dp[0]=sum[1]=1;
        for(int j=1;j<n;j++){
            if(j>=minJump&&s.charAt(j)=='0'&&sum[j-minJump+1]-sum[Math.max(j-maxJump,0)]>0)
                dp[j]=1;
            sum[j+1]=sum[j]+dp[j];
        }
        return dp[n-1]==1;
    }

    //1871. 跳跃游戏 VII
    //解法一：动态规划+暴力枚举
    //进阶优化
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        //dp的前缀和
        int[] sum=new int[n+1];
        sum[1]=1;//包含了dp[0]=true
        for(int j=1;j<n;j++){
            sum[j+1]=sum[j];//在这里提前继承给下一个状态
            if(j>=minJump&&s.charAt(j)=='0'&&sum[j-minJump+1]-sum[Math.max(j-maxJump,0)]>0)
                sum[j+1]++;//包含了dp[j]=true
        }
        return sum[n]>sum[n-1];//dp[n-1]==true;
    }

    //1871. 跳跃游戏 VII
    //解法二：差分数组
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        int[] diff=new int[n+1];
        //一开始在起点0，把[0,0]加一
        diff[0]=1;
        diff[1]=-1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            //现在sum是下标 i 的标记次数
            if(sum>0&&s.charAt(i)=='0'){//i可以跳到
                //[i+minJump,i+maxJump]可以跳到
                diff[Math.min(i+minJump,n)]++;
                diff[Math.min(i+maxJump+1,n)]--;
            }
        }
        return sum>0&&s.charAt(n-1)=='0';//n-1可以跳到
    }
    
}
