import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-25
 * Time: 22:30
 */
class Solution {
    //132.分割回文串 II
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=i+1<j?dp[i+1][j-1]:true;
        int[] dp2=new int[n];
        Arrays.fill(dp2,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            if(dp[0][i]) dp2[i]=0;
            else{
                for(int j=i;j>0;j--){
                    // if(dp[0][i]) dp2[i]=0;
                    if(dp[j][i]) dp2[i]=Math.min(dp2[j-1]+1,dp2[i]);
                }
            }
        }
        return dp2[n-1];
    }
}