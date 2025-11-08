/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-14
 * Time: 23:30
 */
class Solution {
    //5. 最长回文子串
    public String longestPalindrome(String s) {
        int start=0;int n=s.length();int len=0;
        for(int i=0;i<n;i++){
            //先搞奇数的
            int left=i;int right=i;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)) {left--;right++;}
            if(right-left-1>len){len=right-left-1;start=left+1;}//注意是right-left-1因为是两边越界
            //再搞偶数的
            left=i;right=i+1;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)) {left--;right++;}
            if(right-left-1>len){len=right-left-1;start=left+1;}
        }
        return s.substring(start,start+len);
    }
}
