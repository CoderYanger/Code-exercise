/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:47
 */
class Solution {
    //2839. 判断通过操作能否让字符串相等 I
    public boolean canBeEqual(String s1, String s2) {
        //奇数位哈希表
        int[] odd=new int[26];
        //偶数位哈希表
        int[] even=new int[26];
        for(int i=0;i<4;i++){
            if(i%2==0){
                even[s1.charAt(i)-'a']++;
                even[s2.charAt(i)-'a']--;
            }
            else{
                odd[s1.charAt(i)-'a']++;
                odd[s2.charAt(i)-'a']--;
            }
        }
        for(int i=0;i<26;i++){
            if(odd[i]!=0) return false;
            if(even[i]!=0) return false;
        }
        return true;
    }
}