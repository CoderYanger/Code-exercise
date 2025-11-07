/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-14
 * Time: 21:23
 */
class Solution {
    //14. 最长公共前缀

    public String longestCommonPrefix(String[] strs) {
        //解法一：两两比较
        String ret=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<Math.min(strs[i].length(),ret.length())&&strs[i].charAt(j)==ret.charAt(j)) j++;
            ret=ret.substring(0,j);//[0,j)
        }
        return ret;
    }
    public String longestCommonPrefix(String[] strs) {
        //解法二：统一比较
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){//找结束条件
                if(i==strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}