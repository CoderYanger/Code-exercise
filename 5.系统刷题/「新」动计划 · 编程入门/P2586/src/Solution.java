/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:24
 */
class Solution {
    //2586. 统计范围内的元音字符串数
    //1ms击败100.00%
    public int vowelStrings(String[] words, int left, int right) {
        int cnt=0;
        for(int i=left;i<=right;i++){
            //获取该字符串的长度
            int n=words[i].length();
            if(vowel(words[i].charAt(0))&&vowel(words[i].charAt(n-1))) cnt++;
        }
        return cnt;
    }
    //判断该字符是否是原因字符
    private boolean vowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}