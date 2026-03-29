/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 13:33
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    //2的幂
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        //dp[i][j]:前i个数,凑出2的j次幂的最小增量
        int[][] dp=new int[n+1][k+1];
        //初始化为最大值，表示不可达
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],0x3f3f3f3f);
        //前0个数,没有数，也不需要因数2，因此无需增量，故为0
        dp[0][0]=0;
        //遍历第i个数
        for(int i=1;i<=n;i++){
            //遍历2的幂数
            for(int j=0;j<=k;j++){
                //遍历给第i个数分配的指数,题目隐含着k超过16会超范围
                for(int l=0;l<=Math.min(j,16);l++){
                    //x：离a[i-1]最近的2的l次幂的倍数
                    //1<<l：等价于2的l次幂，位运算更高效
                    //(double)a[i-1]/(1<<l):获取a[i-1]是2的l次幂的倍数，转double避免丢失精度
                    //<<l:再把向上取整结果转成2的幂数，得到≥a[i-1]的最小2的l次幂的倍数
                    int x=(int)Math.ceil((double)a[i-1]/(1<<l))<<l;
                    if(x<=100_000&&dp[i-1][j-l]!=0x3f3f3f3f)
                        //x-a[i-1]:当前第i个数调整到x的最小增量
                        dp[i][j]=Math.min(dp[i-1][j-l]+x-a[i-1],dp[i][j]);
                }
            }
        }
        System.out.println(dp[n][k]==0x3f3f3f3f?-1:dp[n][k]);
        sc.close();
    }
}
