import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-02
 * Time: 20:28
 */
class Solution {
    //面试题01.01.判定字符是否唯一
    /*实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    示例 1：
    输入: s = "leetcode"
    输出: false
    示例 2：
    输入: s = "abc"
    输出: true
    限制：
            0 <= len(s) <= 100
    s[i]仅包含小写字母
    如果你不使用额外的数据结构，会很加分。*/
    public boolean isUnique1(String astr) {
        //解法1：用哈希表,自己想然后自己写的，一次通过
        Map<Character,Integer> hash= new HashMap<>();
        for(int i=0;i<astr.length();i++){
            char ch=astr.charAt(i);
            hash.put(ch,hash.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<astr.length();i++){
            char ch=astr.charAt(i);
            if(hash.get(ch)>1) return false;
        }
        return true;
    }
    public boolean isUnique2(String astr) {
        //解法2：用Set容器,也是自己想，然后自己写的，一次通过
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<astr.length();i++){
            char ch=astr.charAt(i);
            if(!set.contains(ch)) set.add(ch);
            else return false;
        }
        return true;
    }
    public boolean isUnique3(String astr) {
        //解法3：吴小哲教的：用一个int当哈希表用（就是位图）
        int bitMap=0;
        for(int i=0;i<astr.length();i++){
            int x=astr.charAt(i)-'a';
            //1)==1这里要加上括号，否则会&一个boolean类型而报错
            if(((bitMap>>x)&1)==1) return false;
            bitMap|=(1<<x);
        }
        return true;
    }
}