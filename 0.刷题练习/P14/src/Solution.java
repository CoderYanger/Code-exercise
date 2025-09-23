import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-07
 * Time: 09:05
 */
class Solution {
    //14. 最长公共前缀
    /*编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
    示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"
    示例 2：
    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。
    提示：
            1 <= strs.length <= 200
            0 <= strs[i].length <= 200
    strs[i] 如果非空，则仅由小写英文字母组成*/

    //自己写的，一堆错误

    /*public String longestCommonPrefix(String[] strs) {
        List<Character> list1=new ArrayList<>();
        List<Character> list2=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            int j=0;
            while(j<strs[i].length()){
                if(i==0){
                    for(int m=0;m<strs[0].length();m++){
                        list1.add(strs[0].charAt(m));
                    }
                }else{
                    for(int n=0;n<strs[i].length();n++){
                        //从头逐个比较两个字符串的字符
                        if(list1.get(n)==strs[i].charAt(n)){
                            //将公共的前缀放在list2里
                            list2.add(strs[i].charAt(n));
                            //清空list1
                            list1.clear();
                            //更新list1，将list2所有元素赋值给list1
                            for(int k=0;k<list2.size();k++){
                                list1.add(list2.get(k));
                            }
                        }else{
                            break;
                        }
                    }
                }
                j++;
            }
        }
        //此时list1中存的就是最长公共前缀
        if(list1.size()>0){
            StringBuilder sb=new StringBuilder();
            for(int g=0;g<list1.size();g++){
                sb.append(list1.get(g));
            }
            return sb.toString();
        }else{
            return "";
        }
    }*/
    //豆包给的最简洁版本
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        String p=strs[0];
        for(String s:strs){
            while(!s.startsWith(p)){
                p=p.substring(0,p.length()-1);
            }
        }
        return p;
    }

}