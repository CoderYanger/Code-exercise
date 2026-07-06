import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-29
 * Time: 18:42
 */
class Solution {
    //3121. 统计特殊字母的数量 II
    public int numberOfSpecialChars(String word) {
        int[] hash=new int[26];
        int[] Hash=new int[26];
        Arrays.fill(hash,-1);
        Arrays.fill(Hash,-1);
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>=97) hash[c-'a']=i;//更新小写字母出现的最后一次位置
            else{
                if(Hash[c-'A']!=-1) continue;
                else Hash[c-'A']=i;//更新大写字母第一次出现的位置
            }
        }
        int cnt=0;
        for(int i=0;i<26;i++)
            if(hash[i]!=-1&&Hash[i]!=-1&&hash[i]<Hash[i]) cnt++;
        return cnt;
    }
}