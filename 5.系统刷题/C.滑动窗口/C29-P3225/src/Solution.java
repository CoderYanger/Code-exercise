/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-10
 * Time: 21:24
 */
class Solution {
    //3325. 字符至少出现 K 次的子字符串 I
    public int numberOfSubstrings(String ss, int k) {
        int[] hash=new int[26];
        char[] s=ss.toCharArray();
        int ret=0,left=0;
        for(char c:s){
            //进窗口
            hash[c-'a']++;
            //出窗口
            while(hash[c-'a']>=k)
                hash[s[left++]-'a']--;
            //更新
            ret+=left;
        }
        return ret;
    }
}