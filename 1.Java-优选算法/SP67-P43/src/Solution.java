/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-15
 * Time: 21:23
 */
class Solution {
    //43. 字符串相乘
    public String multiply(String num1, String num2) {
        //解法二：先相乘相加最后处理进位
        //1.准备工作
        int m=num1.length(),n=num2.length();
        char[]n1=new StringBuffer(num1).reverse().toString().toCharArray();
        char[]n2=new StringBuffer(num2).reverse().toString().toCharArray();
        int[] tmp=new int[m+n-1];
        //2.相乘相加
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tmp[i+j]+=(n1[i]-'0')*(n2[j]-'0');
            }
        }
        //3.解决进位
        int cur=0,t=0;
        StringBuffer ret=new StringBuffer();
        while(cur<m+n-1||t>0){
            if(cur<m+n-1) t+=tmp[cur++];
            ret.append((char)((char)(t%10)+'0'));
            t/=10;
        }
        //4.解决前导0
        while(ret.length()>1&&ret.charAt(ret.length()-1)=='0'){
            ret.deleteCharAt(ret.length()-1);
        }
        return ret.reverse().toString();
    }
}