/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:31
 */
import java.util.Scanner;
public class Main {
    //因数平方和
    private static final int MOD=1_000_000_007;
    private static final long INV6=1_666_666_68;
    //计算平方和：1²+2²+3²+……+x²
    private static long squareSum(long x){
        return ((x*(x+1)%MOD)*((2*x+1)%MOD)%MOD*INV6%MOD);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long ret=0L;
        //数论分块的右端点，记录当前块的最右位置
        long right;
        for(long left=1L;left<=n;left=right+1){
            //记录当前块的右端点
            right=n/(n/left);
            //计算[left,right]区间内所有数的平方和
            //×(n/left):当前块内有(n/left)个相同的值
            ret+=(squareSum(right)-squareSum(left-1))*(n/left)%MOD;
            //由于计算平方和时用到了取模，最终结果可能出现负数
            ret=(ret+MOD)%MOD;
        }
        System.out.println(ret);
        sc.close();
    }
}