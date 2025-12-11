/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-28
 * Time: 23:32
 */
import java.util.Scanner;
import java.lang.Math;
public class Main {
    //DP42 【模板】完全背包
    //优化前代码
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //获取n种物品
        int n=in.nextInt();
        //获取背包容量
        int V=in.nextInt();
        //物品所占背包体积
        int[] v=new int[n+1];
        //物品价值
        int[] w=new int[n+1];
        //输入
        for(int i=1;i<=n;i++){
            v[i]=in.nextInt();
            w[i]=in.nextInt();
        }
        //解决第一问
        int[][] dp=new int[n+1][V+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=V;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=v[i]) dp[i][j]=Math.max(dp[i][j],dp[i][j-v[i]]+w[i]);
            }
        }
        //输出
        System.out.println(dp[n][V]);

        //解决第二问
        int[][] dp2=new int[n+1][V+1];
        //初始化
        for(int j=1;j<=V;j++) dp2[0][j]=-1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=V;j++){
                dp2[i][j]=dp2[i-1][j];
                if(j>=v[i]&&dp2[i][j-v[i]]!=-1) dp2[i][j]=Math.max(dp2[i][j],dp2[i][j-v[i]]+w[i]);
            }
        }
        dp2[n][V]=dp2[n][V]==-1?0:dp2[n][V];
        //输出
        System.out.println(dp2[n][V]);
    }

    //优化后代码,还是用-1表示没有这种情况
    public static void main2(String[] args){
        Scanner in=new Scanner(System.in);
        //获取n种物品
        int n=in.nextInt();
        //获取背包容量
        int V=in.nextInt();
        //物品所占背包体积
        int[] v=new int[n+1];
        //物品价值
        int[] w=new int[n+1];
        //输入
        for(int i=1;i<=n;i++){
            v[i]=in.nextInt();
            w[i]=in.nextInt();
        }
        //解决第一问
        int[] dp=new int[V+1];
        for(int i=1;i<=n;i++){
            for(int j=v[i];j<=V;j++){
                // dp[i][j]=dp[i-1][j];
                // if(j>=v[i])
                dp[j]=Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }
        //输出
        System.out.println(dp[V]);

        //解决第二问
        int[] dp2=new int[V+1];
        //初始化
        for(int j=1;j<=V;j++) dp2[j]=-1;
        for(int i=1;i<=n;i++){
            for(int j=v[i];j<=V;j++){
                // dp2[i][j]=dp2[i-1][j];
                if(dp2[j-v[i]]!=-1) //依旧用-1表示没有这种情况，要有if
                    dp2[j]=Math.max(dp2[j],dp2[j-v[i]]+w[i]);
            }
        }
        dp2[V]=dp2[V]==-1?0:dp2[V];
        //输出
        System.out.println(dp2[V]);
    }

    //优化后代码,这次用-0x3f3f3f3f表示没有这种情况
    public static void main3(String[] args){
        Scanner in=new Scanner(System.in);
        //获取n种物品
        int n=in.nextInt();
        //获取背包容量
        int V=in.nextInt();
        //物品所占背包体积
        int[] v=new int[n+1];
        //物品价值
        int[] w=new int[n+1];
        //输入
        for(int i=1;i<=n;i++){
            v[i]=in.nextInt();
            w[i]=in.nextInt();
        }
        //解决第一问
        int[] dp=new int[V+1];
        for(int i=1;i<=n;i++){
            for(int j=v[i];j<=V;j++){
                dp[j]=Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }
        //输出
        System.out.println(dp[V]);

        //解决第二问
        int[] dp2=new int[V+1];
        //初始化（改为-0x3f3f3f3f）
        for(int j=1;j<=V;j++) dp2[j]=-0x3f3f3f3f;
        for(int i=1;i<=n;i++){
            for(int j=v[i];j<=V;j++){
                //此处if可以删掉了，dp2[j-v[i]]+w[i]已经足够小了
                dp2[j]=Math.max(dp2[j],dp2[j-v[i]]+w[i]);
            }
        }
        //这里改成<0
        dp2[V]=dp2[V]<0?0:dp2[V];
        //输出
        System.out.println(dp2[V]);
    }
}