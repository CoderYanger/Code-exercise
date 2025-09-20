import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-02
 * Time: 09:10
 */
class Solution {
    //3. 无重复字符的最长子串
    /*给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
    示例 1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    提示：
            0 <= s.length <= 5 * 104
    s 由英文字母、数字、符号和空格组成*/
    //自己写的
/*    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        int count=0;
        if(s.length()==0){
            return 0;
        }else{
            for(int j=0;j<s.length();j++){
                for(int i=j;i<s.length();i++){
                    char c=s.charAt(i);
                    if(!set.contains(c)){
                        set.add(c);
                        count++;
                    }else{
                        list.add(count);
                        set.clear();
                        set.add(c);
                        count=1;
                    }
                }
                list.add(count);
            }
            list.add(count);
        }
        int max=0;
        for(int i=0;i<list.size();i++){
            max=(list.get(i)>max)?list.get(i):max;
        }
        return max;
    }*/
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet<>();
        int max=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
//            max=(max>(right-left+1))?max:(right-left+1);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
