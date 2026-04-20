/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-09
 * Time: 22:25
 */
class Solution {
    //2606. 找到最大开销的子字符串
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        //将所有字符的价值存进nums
        int[] nums=new int[27];
        for(int i=1;i<27;i++) nums[i]=i;
        for(int i=0;i<chars.length();i++) nums[chars.charAt(i)-'a'+1]=vals[i];
        int n=s.length();
        //dp[i]:以i位置结尾的最大开销
        int[] dp=new int[n];
        dp[0]=nums[s.charAt(0)-'a'+1];
        int ret=Math.max(0,dp[0]);
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[s.charAt(i)-'a'+1],nums[s.charAt(i)-'a'+1]);
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }

    //空间优化版
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        //将所有字符的价值存进nums
        int[] nums=new int[27];
        for(int i=1;i<27;i++) nums[i]=i;
        for(int i=0;i<chars.length();i++) nums[chars.charAt(i)-'a'+1]=vals[i];
        int n=s.length();
        int dp=nums[s.charAt(0)-'a'+1];
        int ret=Math.max(0,dp);
        for(int i=1;i<n;i++){
            dp=Math.max(dp+nums[s.charAt(i)-'a'+1],nums[s.charAt(i)-'a'+1]);
            ret=Math.max(ret,dp);
        }
        return ret;
    }
}