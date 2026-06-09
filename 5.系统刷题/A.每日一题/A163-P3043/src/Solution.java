import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-22
 * Time: 17:17
 */
class Solution {
    //3043. 最长公共前缀的长度
    //解法一：字符串+哈希表
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> hash1=new HashSet<>();
        Set<String> hash2=new HashSet<>();
        for(int x:arr1){
            String s=String.valueOf(x);
            for(int i=0;i<s.length();i++){
                String pre=s.substring(0,i+1);//截取范围在[0,i+1)
                hash1.add(pre);
            }
        }
        for(int x:arr2){
            String s=String.valueOf(x);
            for(int i=0;i<s.length();i++){
                String pre=s.substring(0,i+1);
                hash2.add(pre);
            }
        }
        int ret=0;
        for(String s:hash1) if(hash2.contains(s)&&s.length()>ret) ret=s.length();
        return ret;
    }

    //解法一优化：字符串+哈希表
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> hash=new HashSet<>();
        for(int x:arr1){
            String s=String.valueOf(x);
            for(int i=0;i<s.length();i++)
                hash.add(s.substring(0,i+1));
        }
        int ret=0;
        for(int x:arr2){
            String s=String.valueOf(x);
            for(int i=0;i<s.length();i++){
                if(!hash.contains(s.substring(0,i+1))) break;
                ret=Math.max(ret,i+1);
            }
        }
        return ret;
    }

    //解法二：整数处理+哈希表
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> hash=new HashSet<>();
        for(int x:arr1) for(;x>0;x/=10) hash.add(x);
        int mx=0;
        for(int x:arr2){
            while(x>0&&!hash.contains(x)) x/=10;
            mx=Math.max(mx,x);
        }
        return mx>0?Integer.toString(mx).length():0;
    }
    
}