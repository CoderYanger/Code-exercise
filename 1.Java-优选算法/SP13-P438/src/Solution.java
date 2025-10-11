import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-25
 * Time: 21:57
 */
class Solution {
    //438. 找到字符串中所有字母异位词
    /*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    示例 1:
    输入: s = "cbaebabacd", p = "abc"
    输出: [0,6]
    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    示例 2:
    输入: s = "abab", p = "ab"
    输出: [0,1,2]
    解释:
    起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
    起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
    起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
    提示:
            1 <= s.length, p.length <= 3 * 104
    s 和 p 仅包含小写字母*/
    public List<Integer> findAnagrams(String s, String p) {
        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        List<Integer> list=new ArrayList<>();
        int[]hash1=new int[26];
        int[]hash2=new int[26];
        int n=ss.length,m=pp.length;
        int count=0;
        if(n<m) return list;
        for(char x:pp) hash1[x-'a']++;
        for(int left=0,right=0;right<n;right++){
            char in=ss[right];
            if(++hash2[in-'a']<=hash1[in-'a']) count++;//进窗口,由于是先加再判断，所以可以取等号
            if(right-left+1>m){
                char out=ss[left++];
                if(hash2[out-'a']--<=hash1[out-'a'])  count--;
            }
            if(count==m) list.add(left);
        }
        return list;
    }
}