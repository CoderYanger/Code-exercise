/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-05
 * Time: 23:37
 */
class Solution {
    //409. 最长回文串
    //看完算法原理后自己写的，基本没啥问题
    public int longestPalindrome(String s) {
        //此处看了一眼吴小哲的代码：用数组模拟哈希表
        char[] hash=new char[128];
        //这里不能直接写s，而是要先转化成字符数组，for-each遍历不支持字符串
        for(char x:s.toCharArray()) hash[x-'A']++;//x-'A'写成x也行，128足够大了，不会越界
        int ret=0;
        for(int x:hash) if(x!=0) ret+=x/2*2;
        return ret<s.length()?ret+1:ret;
    }
}