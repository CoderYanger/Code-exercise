/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-29
 * Time: 18:41
 */
class Solution {
    //3120. 统计特殊字母的数量 I
    public int numberOfSpecialChars(String word) {
        boolean[] hash=new boolean[26];
        boolean[] Hash=new boolean[26];
        for(char c:word.toCharArray()){
            if(c>=97) hash[c-'a']=true;
            else Hash[c-'A']=true;
        }
        int cnt=0;
        for(int i=0;i<26;i++)
            if(hash[i]&&Hash[i])
                cnt++;
        return cnt;
    }
}
