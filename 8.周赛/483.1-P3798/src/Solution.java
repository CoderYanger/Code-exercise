/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-05
 * Time: 22:28
 */
class Solution {
    //3798. 最大的偶数
    public String largestEven(String s) {
        for(int i=s.length()-1;i>=0;i--)
            if(s.charAt(i)=='2') return s.substring(0,i+1);
        return "";
    }
}