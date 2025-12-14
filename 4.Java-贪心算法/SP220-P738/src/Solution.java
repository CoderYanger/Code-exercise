/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-10
 * Time: 19:06
 */
class Solution {
    //738. 单调递增的数字
    public int monotoneIncreasingDigits(int n) {
        //自己的写法，有些语法错误，还没有判断相等时需要回退的情况
        //String ss=new String(n);
        //char[] s=ss.toCharArray();
        //int m=s.length;
        //for(int i=1;i<m;){
        //    while(s[i]>=s[i-1]) i++;
        //    if(s[i]<s[i-1]){
        //        s[i-1]-=1;
        //        for(int j=i;j<m;j++) s[j]=9;
        //    }
        //}
        //String ret=new String(s);
        //return ret;

        //吴小哲的代码，还是看吴小哲的了
        //把数字转化为字符串
        char[] s=Integer.toString(n).toCharArray();
        int i=0;int m=s.length;
        //找到第一个递减的位置
        while(i+1<m&&s[i]<=s[i+1]) i++;
        if(i==m-1) return n;//特判一下特殊情况
        //回退
        while(i-1>=0&&s[i]==s[i-1]) i--;
        s[i]--;
        for(int j=i+1;j<m;j++) s[j]='9';
        //字符数组解析成字符串，再将字符串解析成整数
        return Integer.parseInt(new String(s));
    }
}