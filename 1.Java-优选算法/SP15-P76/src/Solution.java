import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-26
 * Time: 23:14
 */
class Solution {
    //76. 最小覆盖子串
    /*给你一个字符串 s 、一个字符串 t 。
    返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    注意：
    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    如果 s 中存在这样的子串，我们保证它是唯一的答案。
    示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
    解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    示例 2：
    输入：s = "a", t = "a"
    输出："a"
    解释：整个字符串 s 是最小覆盖子串。
    示例 3:
    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。
    提示：
    m == s.length
    n == t.length
1 <= m, n <= 105
    s 和 t 由英文字母组成
    进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？*/
    //第一遍，自己写的
    /*public String minWindow(String s, String t) {
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        List<Character> list=new ArrayList<>();
        HashMap<Character,Integer> hash1=new HashMap<>();
        for(char ch:tt) hash1.put(ch,hash1.getOrDefault(ch,0)+1);
        int n=ss.length,m=tt.length,len=Integer.MAX_VALUE;
        HashMap<Character,Integer> hash2=new HashMap<>();
        for(int left=0,right=0,count=0;right<n;right++){
            char in=ss[right];boolean Is=false;
            hash2.put(in,hash2.getOrDefault(in,0)+1);
            if(hash2.get(in)<=hash1.getOrDefault(in,0)) count++;
            if(count==m){
                if(len>right-left+1){
                    len=right-left+1;
                    list.clear();
                    for(int i=left;i<right+1;i++){
                        list.add(ss[i]);
                    }
                    Is=true;
                }
            }
            if(Is){
                char out=ss[left];
                if(hash2.get(out)<=hash1.getOrDefault(out,0)){
                    hash2.put(out,hash2.getOrDefault(out,0)-1);
                    left++;
                }
            }
        }
        String str=list.toString();
        return str;
    }*/

    //自己写的第二版

    /*public String minWindow(String s, String t) {
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        HashMap<Character,Integer> hash1=new HashMap<>();
        for(char ch:tt) hash1.put(ch,hash1.getOrDefault(ch,0)+1);
        int n=ss.length,m=tt.length,len=Integer.MAX_VALUE;
        HashMap<Character,Integer> hash2=new HashMap<>();
        int start=0;
        for(int left=0,right=0,count=0;right<n;right++){
            char in=ss[right];
            hash2.put(in,hash2.getOrDefault(in,0)+1);
            if(hash2.get(in)<=hash1.getOrDefault(in,0)) count++;
            while(count==m){
                if(right-left+1<len){
                    len=right-left+1;
                    start=left;
                    char out=ss[left];
                    if(hash2.get(out)<=hash1.getOrDefault(out,0)){
                        count--;
                        left++;
                    }
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }*/

    //自己写的第三版，解决了left无法每次保证移动的问题，和对应的hash2的更新

    /*public String minWindow(String s, String t) {
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        HashMap<Character,Integer> hash1=new HashMap<>();
        for(char ch:tt) hash1.put(ch,hash1.getOrDefault(ch,0)+1);
        int n=ss.length,m=tt.length,len=Integer.MAX_VALUE;
        HashMap<Character,Integer> hash2=new HashMap<>();
        int start=0;
        for(int left=0,right=0,count=0;right<n;right++){
            char in=ss[right];
            hash2.put(in,hash2.getOrDefault(in,0)+1);
            if(hash2.get(in)<=hash1.getOrDefault(in,0)) count++;
            while(count==m){
                if(right-left+1<len){
                    len=right-left+1;
                    start=left;
                }
                char out=ss[left];
                if(hash2.get(out)<=hash1.getOrDefault(out,0)) count--;
                hash2.put(out,hash2.getOrDefault(out,0)-1);
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }*/

    //实际正确的方法（理论上也正确）
    //start不可以初始化为0，因为一个字符的时候是0下标
    public String minWindow(String s, String t) {
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        int[] hash1=new int[128];//存放种类
        int[] hash2=new int[128];int kinds=0,minlen= Integer.MAX_VALUE,start=-1;
        for(char ch : tt) if(hash1[ch]++==0) kinds++;
        for(int left=0,right=0,count=0;right<s.length();right++){
            char in=ss[right];
            if(++hash2[in]==hash1[in]) count++;
            while(count==kinds){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }
                char out=ss[left++];
                if(hash2[out]--==hash1[out]) count--;
            }
        }
        if(start==-1) return new String();
        else return s.substring(start,start+minlen);
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="a";
        String t="aa";
        String str=solution.minWindow(s,t);
        System.out.println(str);
    }
}
