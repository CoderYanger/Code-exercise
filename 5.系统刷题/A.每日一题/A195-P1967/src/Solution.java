/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-18
 * Time: 19:31
 */
class Solution {
    //1967. 作为子字符串出现在单词中的字符串数目
    public int numOfStrings(String[] patterns, String word) {
        int cnt=0;
        for(String s:patterns) if(word.contains(s)) cnt++;
        return cnt;
    }
}
