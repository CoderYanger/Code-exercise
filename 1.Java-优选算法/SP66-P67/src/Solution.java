/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-15
 * Time: 21:04
 */
class Solution {
    //67. 二进制求和
    public String addBinary(String a, String b) {
        StringBuffer ret=new StringBuffer();
        int cur1=a.length()-1,cur2=b.length()-1,t=0;
        while(cur1>=0||cur2>=0||t>0){
            if(cur1>=0) t+=a.charAt(cur1--)-'0';
            if(cur2>=0) t+=b.charAt(cur2--)-'0';
            ret.append((char)((char)(t%2)+'0'));
            t/=2;
        }
        return ret.reverse().toString();
    }
}
