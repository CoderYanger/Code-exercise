import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-23
 * Time: 09:29
 */
class Solution {
    //467. 环绕字符串中唯一的子字符串
    //看完算法原理之后自己写的，基本一遍过
    //吴小哲跟我写的大体一样，只不过它是把s转换成字符数组了
    public int findSubstringInWraproundString(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            char ch1=s.charAt(i-1);
            char ch=s.charAt(i);
            if((ch1-'a'+1==ch-'a')||ch1=='z'&&ch=='a')
                dp[i]+=dp[i-1];
        }
        int[] hash=new int[26];
        for(int i=0;i<n;i++){
            int ch=s.charAt(i)-'a';
            hash[ch]=Math.max(hash[ch],dp[i]);
        }
        int sum=0;
        for(int x:hash) sum+=x;
        return sum;
    }
}