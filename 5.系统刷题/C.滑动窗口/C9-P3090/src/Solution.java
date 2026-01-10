/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 18:46
 */
class Solution {
    //3090. 每个字符最多出现两次的最长子字符串
    public int maximumLengthSubstring(String ss) {
        //为了提高效率，这里用数组模拟哈希表
        char[] s=ss.toCharArray();
        int[] hash=new int[26];
        int n=s.length,left=0,ret=0;
        for(int right=0;right<n;right++){
            //进窗口
            int in=s[right]-'a';
            hash[in]++;
            //出窗口
            while(hash[in]>2){
                int out=s[left]-'a';//注意out要定义在循环里，方便更新
                hash[out]--;
                left++;
            }
            //更新
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }
}