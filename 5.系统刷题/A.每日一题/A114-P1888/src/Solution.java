/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-07
 * Time: 14:32
 */
class Solution {
    //1888. 使二进制字符串字符交替的最少反转次数
    //思路一：环+滑动窗口(会超时)
    public int minFlips(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length,mincnt=n;
        for(int left=0;left<n;left++){//遍历每个开头位置
            int cnt=0;//记录变成0101……翻转次数
            for(int right=0;right<n;right++){//映射到真实位置，模拟当前窗口[left,right]
                int index=(left+right)%n;
                char c=s[index];
                if(c!=(right%2==0?'0':'1')) cnt++;
            }
            //当前起点的最优解
            mincnt=Math.min(mincnt,Math.min(cnt,n-cnt));
        }
        return mincnt;
    }

    //思路二：字符串拼接+滑动窗口-写法一：直接拼接
    public int minFlips(String _s) {
        String _ss=_s+_s;
        char[] ss=_ss.toCharArray();
        char[] s=_s.toCharArray();
        int n=s.length;
        int cnt=0,mincnt=n;//最坏情况下翻转所有字符
        for(int right=1;right<2*n-1;right++){
            //进窗口
            if(ss[right]==ss[right-1]){
                cnt++;
                ss[right]^=1;
            }
            int left=right-n+1;
            if(left<0) continue;
            //更新
            mincnt=Math.min(mincnt,Math.min(cnt,n-cnt));
            //出窗口
            if(ss[left]!=s[left]) cnt--;
        }
        return mincnt==n?0:mincnt;
    }

    //思路二：字符串拼接+滑动窗口-写法二：下标映射模拟拼接
    public int minFlips(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        int mincnt=n,cnt=0;
        //遍历到2n-1，用right%n模拟拼接字符串s+s的效果
        for(int right=0;right<2*n-1;right++){
            //判断当前字符s[right%n]是否满足“0101……”模式
            //s[right%n]%2:'0'→0，'1'→1
            //进窗口
            if(s[right%n]%2!=right%2) cnt++;
            int left=right-n+1;
            if(left<0) continue;
            //更新
            //cnt=当前窗口变成0101……的翻转次数
            //n-cnt=当前窗口变成1010……的翻转次数
            mincnt=Math.min(mincnt,Math.min(cnt,n-cnt));
            //出窗口
            //如果之前翻转了，现在要除去当时的翻转操作
            if(s[left]%2!=left%2) cnt--;
        }
        return mincnt;
    }


    //思路二：字符串拼接+滑动窗口-写法三：位运算
    public int minFlips(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        int mincnt=n,cnt=0;
        for(int right=0;right<2*n-1;right++){
            //进窗口
            cnt+=(s[right%n]^right)&1;
            int left=right-n+1;
            if(left<0) continue;
            //更新
            //cnt=当前窗口变成0101……的翻转次数
            //n-cnt=当前窗口变成1010……的翻转次数
            mincnt=Math.min(mincnt,Math.min(cnt,n-cnt));
            //出窗口
            //如果之前翻转了，现在要除去当时的翻转操作
            cnt-=(s[left]^left)&1;
        }
        return mincnt;
    }
    
}