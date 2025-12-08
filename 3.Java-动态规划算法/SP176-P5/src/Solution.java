/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-25
 * Time: 20:19
 */
class Solution {
    //5. 最长回文子串
    //自己写的，一遍过，就是在leetcode647题上截取最大回文子串返回就行了
    //吴小哲也这么写的
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0,len=1;
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=i+1<j?dp[i+1][j-1]:true;
                int tmplen=j-i+1;
                if(tmplen>len&&dp[i][j]==true){
                    len=tmplen;
                    start=i;
                }
            }
        }
        return s.substring(start,start+len);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}