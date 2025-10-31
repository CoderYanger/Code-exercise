/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-11
 * Time: 14:48
 */
class Solution {
    //38. 外观数列
    public String countAndSay(int n) {
        String ret="1";
        for(int i=1;i<n;i++){
            //直接在原字符串上追加时，可能在循环条件上无限满足导致死循环，所以要创建临时变量更新
            StringBuilder tmp=new StringBuilder();
            for(int right=0,left=0;right<ret.length();){
                while(right<ret.length()&&ret.charAt(right)==ret.charAt(left)) right++;
                tmp.append(Integer.toString(right-left));
                tmp.append(ret.charAt(left));
                left=right;
            }
            ret=tmp.toString();
        }
        return ret;
    }
}