/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:56
 */
import java.util.*;
public class Main{
    //蜗牛
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] x=new int[n+1];
        double[][] dp=new double[n+1][2];
        for(int i=1;i<=n;i++) x[i]=sc.nextInt();
        double[] a=new double[n+1];//第i根传送门入口高度
        double[] b=new double[n+1];//第i根传送门出口高度
        for(int i=1;i<n;i++){
            a[i]=sc.nextDouble();
            b[i+1]=sc.nextDouble();
        }
        dp[1][0]=x[1];//原点走x轴到底部
        dp[1][1]=dp[1][0]+a[1]/0.7;//底部走到传送门入口
        for(int i=2;i<=n;i++){
            //从i-1底部走x轴过来
            double option1=dp[i-1][0]+x[i]-x[i-1];
            //从i-1传送门传送到i的b[i]，再向下爬到底部
            double option2=dp[i-1][1]+b[i]/1.3;
            dp[i][0]=Math.min(option1,option2);
            //从i-1底部走到i底部，再向上爬到a[i]
            double optionA=dp[i-1][0]+(x[i]-x[i-1])+a[i]/0.7;
            //两传送门间花费
            double climb=a[i]>b[i]?(a[i]-b[i])/0.7:(b[i]-a[i])/1.3;
            double optionB=dp[i-1][1]+climb;
            dp[i][1]=Math.min(optionA,optionB);
        }
        System.out.printf("%.2f\n",dp[n][0]);
        sc.close();
    }

    //滚动数组空间优化
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] x=new int[n+1];
        for(int i=1;i<=n;i++) x[i]=sc.nextInt();
        double[] a=new double[n+1];//第i根传送门入口高度
        double[] b=new double[n+1];//第i根传送门出口高度
        for(int i=1;i<n;i++){
            a[i]=sc.nextDouble();
            b[i+1]=sc.nextDouble();
        }
        double dp0=x[1];//原点走x轴到底部
        double dp1=dp0+a[1]/0.7;//底部走到传送门入口
        for(int i=2;i<=n;i++){
            double olddp0=dp0;
            double olddp1=dp1;
            //从i-1底部走x轴过来
            double option1=olddp0+x[i]-x[i-1];
            //从i-1传送门传送到i的b[i]，再向下爬到底部
            double option2=olddp1+b[i]/1.3;
            dp0=Math.min(option1,option2);
            //从i-1底部走到i底部，再向上爬到a[i]
            double optionA=olddp0+(x[i]-x[i-1])+a[i]/0.7;
            //两传送门间花费
            double climb=a[i]>b[i]?(a[i]-b[i])/0.7:(b[i]-a[i])/1.3;
            double optionB=dp1+climb;
            dp1=Math.min(optionA,optionB);
        }
        System.out.printf("%.2f\n",dp0);
        sc.close();
    }
    
}
