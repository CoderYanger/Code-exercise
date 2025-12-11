/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-27
 * Time: 23:05
 */
//这两个包一定要记住！！！
import java.util.Scanner;
import java.lang.Math;
public class Main{
    //DP41 【模板】01背包
    //看完吴小哲的算法原理后自己尝试着写的，发现自己的ACM模式时自己的输入输出有很大欠缺
    //第一次报错是因为结尾处没有判断：dp2[n][V]=dp2[n][V]==-1?0:dp2[n][V];
    //这是用滚动数组优化前的代码
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //获取n个物品
        int n=in.nextInt();
        //获取背包容量
        int V=in.nextInt();
        int[] v=new int[n+1];//所需容积
        int[] w=new int[n+1];//本身价值
        for(int i=1;i<=n;i++){
            v[i]=in.nextInt();
            w[i]=in.nextInt();
        }
        //第一问，不必须装满
        int[][] dp=new int[n+1][V+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=V;j++){
                dp[i][j]=dp[i-1][j];
                if(j-v[i]>=0) dp[i][j]=Math.max(dp[i][j],w[i]+dp[i-1][j-v[i]]);
            }
        System.out.println(dp[n][V]);
        //第二问:必须装满
        int[][] dp2=new int[n+1][V+1];
        //初始化
        for(int j=1;j<=V;j++) dp2[0][j]=-1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=V;j++){
                dp2[i][j]=dp2[i-1][j];
                if(j-v[i]>=0&&dp2[i-1][j-v[i]]!=-1) dp2[i][j]=Math.max(dp2[i][j],w[i]+dp2[i-1][j-v[i]]);
            }
        dp2[n][V]=dp2[n][V]==-1?0:dp2[n][V];
        System.out.println(dp2[n][V]);
    }
    public class Main2 {
        //这是用滚动数组优化后的代码
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            //获取n个物品
            int n = in.nextInt();
            //获取背包容量
            int V = in.nextInt();
            int[] v = new int[n + 1];//所需容积
            int[] w = new int[n + 1];//本身价值
            for (int i = 1; i <= n; i++) {
                v[i] = in.nextInt();
                w[i] = in.nextInt();
            }
            //第一问，不必须装满
            int[] dp = new int[V + 1];
            for (int i = 1; i <= n; i++)
                //遍历方向改变
                for (int j = V; j >= 1; j--) {//也可以改成for(int j=V;j>=v[i];j--)这样有常数级的提升，因为v[i]后面的遍历都是无意义的，然后下面的if就可以删掉了，第二问的这个地方也是这个道理
                    // dp[i][j]=dp[i-1][j];
                    if (j - v[i] >= 0) dp[j] = Math.max(dp[j], w[i] + dp[j - v[i]]);
                }
            System.out.println(dp[V]);
            //第二问:必须装满
            int[] dp2 = new int[V + 1];
            //初始化
            for (int j = 1; j <= V; j++) dp2[j] = -1;
            for (int i = 1; i <= n; i++)
                //遍历方向改变
                for (int j = V; j >= 1; j--) {
                    // dp2[i][j]=dp2[i-1][j];
                    if (j - v[i] >= 0 && dp2[j - v[i]] != -1) dp2[j] = Math.max(dp2[j], w[i] + dp2[j - v[i]]);
                }
            dp2[V] = dp2[V] == -1 ? 0 : dp2[V];
            System.out.println(dp2[V]);
        }
    }
}