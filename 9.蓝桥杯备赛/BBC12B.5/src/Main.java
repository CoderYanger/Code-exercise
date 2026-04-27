/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:39
 */
import java.util.*;
public class Main {
    //路径
    public static void main(String[] args) {
        //dp[n]:从1到n的最短路径
        long[] dp=new long[2022];
        Arrays.fill(dp,0x3f3f3f3f);
        dp[0]=0;dp[1]=0;
        for(int i=2;i<2022;i++){
            for(int j=1;j<=21;j++){
                if(i-j<1) continue;
                dp[i]=Math.min(dp[i],dp[i-j]+lcm(i,i-j));
            }
        }
        System.out.println(dp[2021]);
    }
    //求两数的最大公因数
    private static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
    //求两数的最小公倍数
    private static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
}