/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 16:26
 */
class Solution {
    //100999. 移除尾部元音字母
    public String trimTrailingVowels(String s) {
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') continue;
            else return s.substring(0,i+1);
        }
        //照顾编译器
        return "";
    }
}
