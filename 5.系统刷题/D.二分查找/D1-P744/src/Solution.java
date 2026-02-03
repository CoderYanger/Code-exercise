/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-13
 * Time: 10:20
 */
class Solution {
    //744. 寻找比目标字母大的最小字母
    public char nextGreatestLetter(char[] s, char t) {
        int n=s.length;
        int left=0,right=n-1;
        //求最左端点模型
        while(left<right){
            int mid=left+(right-left)/2;
            if(s[mid]<t) left=mid+1;
            else right=mid;
        }
        while(left+1<n&&s[left]==t) left++;
        return s[left]>t?s[left]:(left+1<n?s[left+1]:s[0]);
    }

    public char nextGreatestLetter(char[] s, char t) {
        int n=s.length;
        int left=0,right=n-1;
        //求最右端点模型
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(s[mid]>t) right=mid-1;
            else left=mid;
        }
        return s[left]>t?s[left]:(left+1<n?s[left+1]:s[0]);
    }
}
