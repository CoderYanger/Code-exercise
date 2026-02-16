import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-21
 * Time: 19:47
 */
class Solution {
    //1930. 长度为 3 的不同回文子序列
    public int countPalindromicSubsequence(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        int ret=0;
        //枚举两边的字符
        for(int c='a';c<='z';c++){
            //分别记录最左侧和最右侧该字符的下标
            int left=0,right=n-1;
            while(left<n&&s[left]!=c) left++;
            while(right>=0&&s[right]!=c) right--;
            //[left,right]包含左右端点，不足3个字符时应为right-left+1<3
            if(right-left<2) continue;
            Set<Character> hash=new HashSet<>();
            for(int i=left+1;i<=right-1;i++)
                hash.add(s[i]);
            ret+=hash.size();
        }
        return ret;
    }

    public int countPalindromicSubsequence2(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        int ret=0;
        //开26大小大小的数组，0－26表示从a-z
        int[] prev=new int[26];//前缀
        int[] suff=new int[26];//后缀
        boolean[][] mark=new boolean[26][26];//[中间字符][两边字符]
        //先给后缀统计
        for(int i=0;i<n;i++) suff[s[i]-'a']++;
        for(int i=0;i<n;i++){//枚举中间元素
            suff[s[i]-'a']--;
            for(int c=0;c<26;c++){//枚举两侧元素
                if(prev[c]>0&&suff[c]>0&&mark[s[i]-'a'][c]==false){
                    ret++;
                    mark[s[i]-'a'][c]=true;
                }
            }
            prev[s[i]-'a']++;
        }
        return ret;
    }
}