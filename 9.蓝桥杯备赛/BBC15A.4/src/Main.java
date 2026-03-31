/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 14:13
 */
import java.util.*;
public class Main{
    //回文数组
    //正解：
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++) a[i]=sc.nextLong();
        long ret=0;
        for(int i=0;i<n/2;i++){
            //找到对称位置
            int sy=n-1-i;
            //计算当前值与其对称位置的差
            long gap1=a[i]-a[sy];
            //计算i+1位置与其对称位置的差
            long gap2=a[i+1]-a[sy-1];
            //先将当前位置的操作次数加上
            ret+=gap1>0?gap1:-gap1;
            //如果跟后一个同号，就顺便捎上
            if(gap1>0&&gap2>0||gap1<0&&gap2<0){
                long tmp=Math.min(Math.abs(gap1),Math.abs(gap2));
                a[i+1]+=gap2>0?-tmp:tmp;
            }
        }
        System.out.println(ret);
        sc.close();
    }

    //一开始动态规划的错误代码：
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        long[] diff=new long[n/2];
        for(int i=0;i<n/2;i++) diff[i]=Math.abs(a[i]-a[n-1-i]);
        //dp[i][0]:仅选当前位置的最少次数
        //dp[i][1]:选前一个位置及当前位置的最少次数
        long[][] dp=new long[n/2][2];
        dp[0][0]=diff[0];
        dp[0][1]=diff[0];
        for(int i=1;i<n/2;i++){
            //选前一个位置
            long premin=i>=2?Math.min(dp[i-2][1],dp[i-2][0]):0;
            dp[i][1]=premin+Math.max(diff[i],diff[i-1]);
            //不选前一个位置
            dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1])+diff[i];
        }
        System.out.println(Math.min(dp[n/2-1][0],dp[n/2-1][1]));
        sc.close();
    }
}