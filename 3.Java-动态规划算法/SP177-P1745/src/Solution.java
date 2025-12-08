/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-25
 * Time: 21:18
 */
class Solution {
    //1745.回文串分割IV 
    //自己写的，一开始放在两层循环内了，发现不行，因为即使前面有回文，那也还没被遍历过，一定还是false
    //第二次出错是第二个for循环里到n-1就行了，再往后第三段就没有元素了
    public boolean checkPartitioning(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=i+1<j?dp[i+1][j-1]:true;
        for(int i=1;i<n-1;i++)
            for(int j=i;j<n-1;j++)
                if(dp[0][i-1]&&dp[i][j]&&dp[j+1][n-1]) return true;
        return false;
    }
}