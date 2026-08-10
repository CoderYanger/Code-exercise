import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-29
 * Time: 01:26
 */
class Solution {
    //3536. 两个数字的最大乘积
    //解法一：排序
    public int maxProduct(int n) {
        char[] s=String.valueOf(n).toCharArray();
        Arrays.sort(s);
        int m=s.length;
        return (s[m-1]-'0')*(s[m-2]-'0');
    }

    //3536. 两个数字的最大乘积
    //解法二：维护最大值次大值
    public int maxProduct(int n) {
        int mx=0,mx2=0;
        while(n>0){
            int d=n%10;
            if(d>mx){
                mx2=mx;
                mx=d;
            }else if(d>mx2) mx2=d;
            n/=10;
        }
        return mx*mx2;
    }
}
