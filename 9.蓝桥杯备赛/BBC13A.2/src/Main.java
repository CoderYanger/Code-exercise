
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:29
 */
import java.util.*;
public class Main{
    //寻找整数
    public static void main(String[] args){
        int[] nums= {1,2,1,4,5,4,1,2,9,0,5,10,11,14,9,0,11,18,9,11,11,15,17, 9,23,20,25,16,29,27,25,11,17,4,29,22,37,23,9,1,11,11,33,29,15,5,41,46};
        long x=1;
        long temp=2;//步长
        for(int i=2;i<=49;i++){
            while(x%i!=nums[i-2]) x+=temp;
            temp=lcm(temp,i);
        }
        System.out.println(x);
    }
    private static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    private static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
