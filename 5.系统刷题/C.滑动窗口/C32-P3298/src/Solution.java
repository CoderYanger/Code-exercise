/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-11
 * Time: 21:06
 */
class Solution {
    //3298. 统计重新排列后包含另一个字符串的子字符串数目 II
    public long validSubstringCount(String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        if(n1<n2) return 0;
        int[] hash1=new int[26];
        int[] hash2=new int[26];
        long ret=0;
        for(char c:s2.toCharArray()) hash2[c-'a']++;
        for(int left=0,right=0;right<n1;right++){
            //进窗口
            hash1[s1.charAt(right)-'a']++;
            //出窗口
            while(ismatch(hash1,hash2))
                hash1[s1.charAt(left++)-'a']--;
            //更新
            ret+=left;
        }
        return ret;
    }
    private boolean ismatch(int[] hash1,int[] hash2){
        for(int i=0;i<26;i++)
            if(hash1[i]<hash2[i]) return false;
        return true;
    }
}