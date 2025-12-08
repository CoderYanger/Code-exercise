/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-25
 * Time: 18:38
 */
class Solution {
    //647. 回文子串
    //吴小哲直接在原字符串上写的，更简洁些，我这个本质上跟他十一样的
    public int countSubstrings(String ss) {
        int n=ss.length();
        char[] s=ss.toCharArray();
        boolean[][] dp=new boolean[n][n];
        int sum=0;
        //调试之后发现for(int i=0;i<n;i++)是错的
        //因为这种情况下，i在头，j在尾的时候，中间是还没有走过的，一定是false，但中间的dp还需要用
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s[i]!=s[j]) dp[i][j]=false;
                else{
                    if(i==j||i+1==j) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }
                //上面吴小哲这么写的：
                //dp[i][j]=i+1<j?dp[i+1][j-1]:true;
                if(dp[i][j]==true) sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.countSubstrings("aaa"));
    }
}