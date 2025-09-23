import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-03
 * Time: 15:06
 */
class Solution {
    //5. 最长回文子串
    /*给你一个字符串 s，找到 s 中最长的 回文 子串。
    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：
    输入：s = "cbbd"
    输出："bb"
    提示：
            1 <= s.length <= 1000
    s 仅由数字和英文字母组成*/

    //自己实现的：
    /*一、主要问题
    语法错误：
            for 循环变量声明错误：for(int n=maxlist.size()-1,int m=0;...) 中多个变量声明不能重复用int，应改为 int n = ..., m = ...
    返回值类型不匹配：方法声明返回String，但实际返回char[]，需转换为String
    数组索引操作错误：arr[maxlist.size()++] 会导致索引越界且逻辑混乱
    循环条件错误：i<s.length()-2 会遗漏字符串首尾的潜在回文中心
    逻辑错误：
    临时列表未清空：list1和list2在每次循环后未重置，导致累计旧数据，影响长度判断
    回文扩展逻辑错误：
    奇数回文的while(j<i)条件不合理，应判断边界（i-j >=0和i+j < s.length()）
    向列表添加字符的方式错误，未正确记录回文子串的所有字符
    回文构建逻辑错误：通过list转换为数组的过程混乱，无法正确还原回文结构*/

    /*public String longestPalindrome(String s) {
        List<Character> list1=new ArrayList<>();
        List<Character>list2=new ArrayList<>();
        List<Character>maxlist=new ArrayList<>();
        for(int i=1;i<s.length()-2;i++){
            int j=0;
            //奇数回文
            while(j<i&&s.charAt(i-j)==s.charAt(i+j)){
                list1.add(s.charAt(i+j));
            }
            if(list1.size()>maxlist.size()){
                maxlist=new ArrayList<>(list1);
            }
            //偶数回文
            while(j<i&&s.charAt(i-(j+1))==s.charAt(i+j)){
                list2.add(s.charAt(i+j));
            }
            if(list2.size()>maxlist.size()){
                maxlist=new ArrayList<>(list2);
            }
        }
        if(maxlist.size()==list1.size()){
            char[]arr=new char[maxlist.size()*2-1];
            for(int n=maxlist.size()-1,int m=0;m<maxlist.size()&&n>=0;m++,n--){
                arr[maxlist.size()++]=maxlist.get(m);
                arr[n--]=maxlist.get(m-1);
            }
            return arr;
        }else if(maxlist.size()==list2.size()){
            char[]arr=new char[maxlist.size()*2];
            for(int n=maxlist.size()-1,int m=0;m<maxlist.size()&&n>=0;m++,n--){
                arr[maxlist.size()++]=maxlist.get(m);
                arr[n--]=maxlist.get(m-1);
            }
            return arr;
        }
    }*/

        public String longestPalindrome(String s) {
            if(s==null||s.length()<=1){
                return s;//空串或者单字符直接返回
            }
            int maxlen=1;//最长回文长度（至少为1）
            int start=0;//最长回文的起始索引
            for(int i=0;i<s.length();i++){
                //奇数长度回文（中心为i）
                int len1=expand(s,i,i);
                //偶数长度回文（中心为i和i+1）
                int len2=expand(s,i,i+1);
                //更新最长回文的长度和起始索引
                int currentMax=Math.max(len1,len2);
                if(currentMax>maxlen){
                    maxlen=currentMax;
                    //计算起始索引：i-（长度-1）/2(兼容奇偶长度)
                    start=i-(currentMax-1)/2;
                }
            }
            //截取并返回最长回文子串
            return s.substring(start,start+maxlen);
        }
        //中心拓展辅助方法：返回以left和right为中心的回文长度
        private int expand(String s,int left,int right){
            //向两边拓展，直到越界或字符不相等
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            //回文长度=右边界-左边界-1（因为退出时已多扩了一步）
            return right-left-1;
        }
    }
