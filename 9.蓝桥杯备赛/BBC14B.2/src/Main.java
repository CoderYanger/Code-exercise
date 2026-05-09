/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:49
 */
import java.util.Scanner;
public class Main {
    //数组分割
    //动态规划：0-1背包
    private static final int MOD=1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        while(num-->0){
            int n=sc.nextInt();
            int[] a=new int[n+1];
            int odd=0;
            for(int i=1;i<=n;i++){
                a[i]=sc.nextInt();
                if(a[i]%2==1) odd++;
            }
            if(odd%2==1){System.out.println(0);continue;}
            //动态规划
            long[][] dp=new long[n+1][2];
            dp[0][0]=1;
            dp[0][1]=0;
            for(int i=1;i<=n;i++){
                //当前数是偶数
                if(a[i]%2==0){
                    dp[i][0]=(2*dp[i-1][0])%MOD;
                    dp[i][1]=(2*dp[i-1][1])%MOD;
                }
                //当前数是奇数
                else{
                    dp[i][0]=(dp[i-1][1]+dp[i-1][0])%MOD;
                    dp[i][1]=(dp[i-1][0]+dp[i-1][1])%MOD;
                }
            }
            System.out.println(dp[n][0]);
        }
        sc.close();
    }

    //滚动数组空间优化
    private static final int MOD=1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        while(num-->0){
            int n=sc.nextInt();
            int[] a=new int[n+1];
            int odd=0;
            for(int i=1;i<=n;i++){
                a[i]=sc.nextInt();
                if(a[i]%2==1) odd++;
            }
            if(odd%2==1){System.out.println(0);continue;}
            //动态规划
            long dp0=1,dp1=0;
            for(int i=1;i<=n;i++){
                //当前数是偶数
                if(a[i]%2==0){
                    dp0=(2*dp0)%MOD;
                    dp1=(2*dp1)%MOD;
                }
                //当前数是奇数
                else{
                    long olddp0=dp0,olddp1=dp1;
                    dp0=(olddp1+olddp0)%MOD;
                    dp1=(olddp0+olddp1)%MOD;
                }
            }
            System.out.println(dp0);
        }
        sc.close();
    }
}