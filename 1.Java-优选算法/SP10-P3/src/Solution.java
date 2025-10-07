import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-22
 * Time: 23:11
 */
class Solution {
    // 3. 无重复字符的最长子串
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
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int len=0;
        for(int left=0,right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            len=Math.max(right-left+1,len);
        }
        return len;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
