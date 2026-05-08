/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 21:04
 */
import java.util.*;
public class Main{
    //互质数的个数
    //暴力枚举：会超时
    private static final int MOD=998244353;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long a=sc.nextInt(),b=sc.nextInt();
        long ret=0;
        for(int i=2;i<Math.pow(a,b);i++)
            if(check(i,(long)Math.pow(a,b))) ret=(ret+1)%MOD;
        System.out.println(ret);
        sc.close();
    }
    private static boolean check(long x,long t){
        for(int i=2;i<x;i++) if(x%i==0&&t%i==0) return false;
        return true;
    }

    //欧拉函数+快速幂
    private static final int MOD=998244353;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong(),b=sc.nextLong();
        //特殊情况
        if(a==1){System.out.println(0);return;}
        long ret=a;
        long x=a;
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                while(x%i==0) x/=i;
                ret=ret/i*(i-1);
            }
        }
        //最后x>1，说明剩下的x本身是一个质数
        if(x>1) ret=ret/x*(x-1);
        System.out.println(ret*pow(a,b-1)%MOD);
        sc.close();
    }
    //快速幂
    private static long pow(long a,long b){
        long ret=1;
        for(;b>0;b>>=1){
            if((b&1)==1) ret=ret*a%MOD;
            a=a*a%MOD;
        }
        return ret%MOD;
    }
}
