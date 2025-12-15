import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-13
 * Time: 13:13
 */
class Solution {
    //767. 重构字符串
    //看完算法原理自己写的，基本上就是跟上一题一模一样（1054.距离相等的条形码）
    //就是把数字变成字符了而已，基本一遍过
    public String reorganizeString(String ss) {
        char[] s=ss.toCharArray();
        Map<Character,Integer> hash=new HashMap<>();
        int n=s.length,maxcount=0;char maxval=0;
        char[] ret=new char[n];
        for(char c:s){
            hash.put(c,hash.getOrDefault(c,0)+1);
            if(hash.get(c)>maxcount){
                maxval=c;
                maxcount=hash.get(c);
            }
        }
        //无解直接返回空串
        if(maxcount>(n+1)/2) return "";
        //先把出现次数最多的字符放进去
        int index=0;
        for(int i=0;i<maxcount;i++){
            ret[index]=maxval;
            index+=2;
        }
        //把这个出现次数最多的从哈希表中删除
        hash.remove(maxval);
        //剩下的随便填
        for(char c:hash.keySet()){
            for(int i=0;i<hash.get(c);i++){
                if(index>=n) index=1;//index走完一圈，直接到第二个位置
                ret[index]=c;
                index+=2;
            }
        }
        return new String(ret);
    }

    //吴小哲的解法，本质是一样的，只不过改用数组代替哈希表了，会更快些
    public String reorganizeString2(String s) {
        int[] hash=new int[26];
        int n=s.length();
        char[] ret=new char[n];
        char maxchar=' ';int maxcount=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(maxcount<++hash[ch-'a']){
                maxchar=ch;
                maxcount=hash[ch-'a'];
            }
        }
        int index=0;
        if(maxcount>(n+1)/2) return "";
        //把出现次数最多的字符放进去
        for(int i=0;i<maxcount;i++){
            ret[index]=maxchar;
            index+=2;
        }
        hash[maxchar-'a']=0;//用完就置0
        for(int i=0;i<26;i++){
            for(int j=0;j<hash[i];j++){
                if(index>=n) index=1;
                ret[index]=(char)(i+'a');
                index+=2;
            }
        }
        return new String(ret);
    }
}