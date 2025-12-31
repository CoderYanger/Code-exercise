/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-23
 * Time: 12:08
 */
class Solution {
    //100910. 连接非零数字并乘以其数字和 I
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        //先转换成字符串方便找
        String ss=String.valueOf(n);
        char[] s=ss.toCharArray();
        StringBuffer sb=new StringBuffer();
        long sum=0;
        for(char c:s){
            long x=c-'0';
            if(x>0&&x<=9){
                sb.append(c);
                sum+=x;
            }
        }
        long ret=sum*Integer.valueOf(sb.toString());
        return ret;
    }
}