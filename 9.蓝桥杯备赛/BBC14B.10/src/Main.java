/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:55
 */
import java.util.*;
import java.math.BigInteger;
public class Main {
    //阶乘求和
    //解法一：暴力求解
    public static void main(String[] args) {
        BigInteger a=BigInteger.valueOf(1);
        BigInteger sum=BigInteger.ZERO;
        for(int i=2;i<2024;i++){
            sum=sum.add(a);
            a=a.multiply(BigInteger.valueOf(i));
        }
        String ret=sum.toString();
        System.out.println(ret.substring(ret.length()-9));
    }

    //解法二：找规律
    public static void main(String[] args) {
        long sum=0;
        for(int i=1;i<=40;i++){
            //求阶乘
            long a=1;
            for(int j=1;j<=i;j++){
                a*=j;
                a%=1_000_000_000;//取模防溢出
            }
            sum+=a;
        }
        System.out.println(sum%1_000_000_000);
    }

}
