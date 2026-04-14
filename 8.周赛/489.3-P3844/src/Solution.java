/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 18:02
 */
class Solution {
    //解法一：暴力枚举
    public int almostPalindromic(String ss) {
        int ret=0;
        //枚举所有子串
        char[] s=ss.toCharArray();
        int n=s.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(s,i,j,1)) ret=Math.max(ret,j+1-i);
            }
        }
        return ret;
    }
    private boolean check(char[] s,int i,int j,int delete){
        while(i<j){
            if(s[i]!=s[j]){
                if(delete==0) return false;
                return check(s,i+1,j,0)||check(s,i,j-1,0);
            }
            i++;j--;
        }
        return true;
    }

    //解法二：中心扩展法
    public int almostPalindromic(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        if(n==1) return 1;
        int ret=0;
        for(int i=0;i<n;i++){
            //先处理偶数
            int left=i,right=i;
            while(left>=0&&right<n&&s[left]==s[right]){
                left--;right++;
            }
            //计算原生回文串长度
            int origin=right-(left+1);
            int len1=0,len2=0;
            //处理越界
            if(left>=0) len1=expend(s,left-1,right);
            if(right<n) len2=expend(s,left,right+1);
            ret=Math.max(ret,Math.max(origin,Math.max(len1,len2)));
            //再处理奇数
            left=i;right=i+1;
            while(left>=0&&right<n&&s[left]==s[right]){
                left--;right++;
            }
            origin=right-(left+1);
            len1=0;len2=0;
            //处理越界
            if(left>=0) len1=expend(s,left-1,right);
            if(right<n) len2=expend(s,left,right+1);
            ret=Math.max(ret,Math.max(origin,Math.max(len1,len2)));
        }
        return ret;
    }
    private int expend(char[] s,int left,int right){
        while(left>=0&&right<s.length&&s[left]==s[right]){
            left--;right++;
        }
        return right-(left+1);//[left+1,right-1]是回文串
    }
}
