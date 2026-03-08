/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 13:07
 */
class Solution {
    //344. 反转字符串
    public void reverseString(char[] s) {
        //解法一：双指针
        int n=s.length;
        for(int left=0,right=n-1;left<right;left++,right--){
            char tmp=s[left];
            s[left]=s[right];
            s[right]=tmp;
        }
    }
    public void reverseString(char[] s) {
        //解法二：单指针
        int n=s.length;
        for(int i=0;i<n/2;i++){
            char tmp=s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=tmp;
        }
    }
}
