/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-14
 * Time: 21:27
 */
class Solution {
    //91. 解码方法
    public int numDecodings(String s) {
        //自己看完算法原理后写的，注释处是豆包帮忙改的，主要体现在
        //1.数组越界的错误
        //2.dp[1]累加时的错误
        int n=s.length();
        if(n>0&&s.charAt(0)=='0') return 0;
        int[] dp=new int[n];
        int ch0=s.charAt(0)-'0';
        if(ch0<10&&ch0>0) dp[0]++;
        if(n==1) return dp[0];
        if(n>1){
            int ch1=s.charAt(1)-'0';
            //双字符有效+1
            if(ch1+ch0*10<27&&ch1+ch0*10>0) dp[1]++;
            //if(dp[0]==0&&ch1<10&&ch1>0) dp[1]++;
            //单字符有效+dp[0]
            if(ch1>0&&ch1<10) dp[1]+=dp[0];
        }
        if(n==2) return dp[1];
        for(int i=2;i<n;i++){
            int ch=s.charAt(i)-'0';
            if(ch>0&&ch<10) dp[i]+=dp[i-1];
            int tmp=(s.charAt(i-1)-'0')*10+ch;
            if(tmp>9&&tmp<27) dp[i]+=dp[i-2];
        }
        return dp[n-1];
    }

    //看完吴小哲的优化方式后自己按自己的理解写出来的，一遍过
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        if(s.charAt(0)!='0') dp[1]++;
        for(int i=2;i<=n;i++){
            int ch1=s.charAt(i-1)-'0';
            int ch2=s.charAt(i-2)-'0';
            //单独解码
            if(ch1!=0) dp[i]+=dp[i-1];
            //一起解码
            int tmp=ch2*10+ch1;
            if(tmp<=26&&tmp>=10) dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}