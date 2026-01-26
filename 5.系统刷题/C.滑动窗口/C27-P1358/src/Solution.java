/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-10
 * Time: 17:54
 */
class Solution {
    //1358. 包含所有三种字符的子字符串数目
    public int numberOfSubstrings(String ss) {
        int[] hash=new int[3];
        char[] s=ss.toCharArray();
        int left=0,ret=0;
        //固定每个右端点，使left指向恰好不合法的位置，
        //左端点[0,left-1]的长度就是以此右端点时符合结果的合法子数组的个数
        for(char c:s){
            //进窗口
            hash[c-'a']++;
            //出窗口
            while(hash[0]>0&&hash[1]>0&&hash[2]>0)
                hash[s[left++]-'a']--;
            //更新
            ret+=left;
        }
        return ret;
    }
}
