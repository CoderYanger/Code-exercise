import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-08-30
 * Time: 17:47
 */
class Solution {
    //3016. 输入单词需要的最少按键次数 II
    public int minimumPushes(String word) {
        int[] hash=new int[26];
        for(char c:word.toCharArray()) hash[c-'a']++;
        Arrays.sort(hash);
        int cnt=0;
        for(int i=25;i>=0;i--){
            if(i>17) cnt+=hash[i];
            else if(i>9) cnt+=2*hash[i];
            else if(i>1) cnt+=3*hash[i];
            else cnt+=4*hash[i];
        }
        return cnt;
    }
}