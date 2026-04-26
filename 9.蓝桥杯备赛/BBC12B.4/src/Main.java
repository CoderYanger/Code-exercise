/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:38
 */
public class Main {
    //货物摆放
    public static void main(String[] args) {
        long n=2021041820210418L;
        long ret=1;
        //开始找质数
        for(long i=2;i<=n/i;i++){
            if(n%i==0){
                //开始数这个质数在n里有多少
                int cnt=0;
                while(n%i==0){
                    n/=i;
                    cnt++;
                }
                //隔板法计算分法
                ret*=(cnt+2)*(cnt+1)/2;
            }
        }
        //如果最后剩下的n>1，说明它自己是个质数
        if(n>1) ret*=3;
        System.out.println(ret);
    }
}