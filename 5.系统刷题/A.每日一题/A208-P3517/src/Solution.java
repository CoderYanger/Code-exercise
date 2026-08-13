import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-30
 * Time: 16:05
 */
class Solution {
    //3517. 最小回文排列 I
    //解法一：计数排序-写法一：StringBuffer
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        int[] hash=new int[26];
        StringBuffer cur=new StringBuffer();
        for(int i=0;i<s.length()/2;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++)
            while(hash[i]-->0)
                cur.append((char)(i+'a'));
        if(s.length()%2==0)
            return cur.toString()+cur.reverse().toString();
        else
            return cur.toString()+s.charAt(s.length()/2)+cur.reverse().toString();
    }

    //3517. 最小回文排列 I
    //解法一：计数排序-写法二：StringBuilder
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        int[] hash=new int[26];
        StringBuilder cur=new StringBuilder();
        for(int i=0;i<s.length()/2;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++)
            while(hash[i]-->0)
                cur.append((char)(i+'a'));
        if(s.length()%2==0)
            return cur.toString()+cur.reverse().toString();
        else
            return cur.toString()+s.charAt(s.length()/2)+cur.reverse().toString();
    }

    //3517. 最小回文排列 I
    //解法一：计数排序-优化
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        int[] hash=new int[26];
        StringBuilder cur=new StringBuilder();
        for(int i=0;i<n/2;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++) cur.repeat('a'+i,hash[i]);
        //提前拷贝一份
        StringBuilder t=new StringBuilder(cur);
        //回文串长度为奇数就把中间的加上
        if(n%2==1) cur.append(s.charAt(n/2));
        cur.append(t.reverse());
        return cur.toString();
    }

    //3517. 最小回文排列 I
    //解法二：排序左半部分
    public String smallestPalindrome(String s) {
        int n=s.length();
        int m=n/2;
        char[] t=s.substring(0,m).toCharArray();
        Arrays.sort(t);
        StringBuilder cur=new StringBuilder();
        cur.append(t);
        //判断是否是奇数长度回文串
        if(n%2==1) cur.append(s.charAt(m));
        //逆序拼接
        for(int i=m-1;i>=0;i--) cur.append(t[i]);
        return cur.toString();
    }
    
}
