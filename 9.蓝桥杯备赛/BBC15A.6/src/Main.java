/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:36
 */
import java.util.*;
public class Main{
    //砍柴
    //错误解法：贪心
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] ret=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            int cnt=0;
            while(a[i]>=2){
                a[i]-=prime(a[i]);
                cnt++;
            }
            if(cnt%2!=0) ret[i]=1;
        }
        for(int i=0;i<n;i++) System.out.println(ret[i]);
        sc.close();
    }
    //获取n内的最大质数
    private static int prime(int n){
        //埃氏筛
        boolean[] isprime=new boolean[n+1];
        for(int i=2;i<=n;i++) isprime[i]=true;
        for(int i=2;i<=n;i++){
            if(isprime[i]){//若i是质数
                for(int j=i*i;j<=n;j+=i)
                    //则i平方后的所有倍数全不是质数
                    isprime[j]=false;
            }
        }
        for(int i=n;i>=2;i--) if(isprime[i]) return i;
        //照顾编译器
        return -1;
    }

    //正确解法：动态规划
    private static final int MAX_N=100_000;
    private static boolean[] isprime;
    //存储欧拉筛的结果
    private static List<Integer> primes;
    //dp[x]=1：数为x时先手必胜
    //dp[x]=0：数为x时先手必败
    private static int[] dp;
    static{
        isprime=new boolean[MAX_N+1];
        primes=new ArrayList<>();
        Arrays.fill(isprime,true);
        isprime[0]=isprime[1]=false;
        //欧拉筛核心逻辑：保证每个合数只被其最小质因子筛除，时间复杂度O(N)
        for(int i=2;i<=MAX_N;i++){
            if(isprime[i]) primes.add(i);
            //遍历已找到的质数，筛除i*p的合数
            for(int p:primes){
                //防止整数溢出：i*p超过MAX_N时，无需继续筛除
                if(1L*i*p>MAX_N) break;
                //标记i*p为非质数
                isprime[i*p]=false;
                //避免同一个合数被多个因子重复筛除，保证线性复杂度
                if(i%p==0) break;
            }
        }
        //动态规划计算胜负状态
        dp=new int[MAX_N+1];
        //dp[0]=0、dp[1]=0：数为0或1时，无法操作，先手必败
        dp[0]=0;
        dp[1]=0;
        for(int x=2;x<=MAX_N;x++){
            //初始化为必败
            boolean win=false;
            //遍历所有质数，尝试减去一个质数p，看是否能让对手必败
            for(int p:primes){
                if(p>x) break;
                //如果减p后能让对手必败，则当前x为必胜态
                if(dp[x-p]==0){
                    win=true;
                    break;//找到一种必胜策略即可
                }
            }
            dp[x]=win?1:0;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            //直接输出预处理的结果
            System.out.println(dp[n]);
        }
        sc.close();
    }
    
}
