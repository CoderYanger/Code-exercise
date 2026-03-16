/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-05
 * Time: 11:23
 */
class Solution {
    //解法一：枚举
    public int minOperations(String s) {
        int rev=s.charAt(0),cnt1=0,cnt2=0;
        for(char c:s.toCharArray()){
            if(c!=rev) cnt1++;
            rev^=1;
        }
        rev=s.charAt(0);
        for(char c:s.toCharArray()){
            if(c==rev) cnt2++;
            rev^=1;
        }
        return Math.min(cnt1,cnt2);
    }

    //解法一：枚举(优化版)
    public int minOperations(String s) {
        int rev=s.charAt(0),cnt=0;
        for(char c:s.toCharArray()){
            if(c!=rev) cnt++;
            rev^=1;
        }
        return Math.min(cnt,s.length()-cnt);
    }
}
