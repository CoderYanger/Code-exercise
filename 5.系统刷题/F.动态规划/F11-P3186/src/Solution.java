import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-08
 * Time: 19:47
 */
class Solution {
    //3186. 施咒的最大总伤害
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:power) hash.merge(x,1,Integer::sum);
        int n=hash.size();
        int[] a=new int[n];
        int index=0;
        for(int x:hash.keySet()) a[index++]=x;
        Arrays.sort(a);
        //选第i个伤害值能获得的最大伤害
        long[] f=new long[n];
        f[0]=1L*a[0]*hash.get(a[0]);
        //不选第i个伤害值能获得的最大伤害
        long[] g=new long[n];
        g[0]=0;
        int j=0;//指向最后一个与i冲突的位置
        for(int i=1;i<n;i++){
            int x=a[i];//获取当前伤害值
            while(a[j]<x-2) j++;
            f[i]=(j-1>=0?Math.max(f[j-1],g[j-1]):0)+1L*x*hash.get(x);
            g[i]=Math.max(f[i-1],g[i-1])+0;
        }
        return Math.max(f[n-1],g[n-1]);
    }

    //空间优化版
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:power) hash.merge(x,1,Integer::sum);
        int n=hash.size();
        int[] a=new int[n];
        int index=0;
        for(int x:hash.keySet()) a[index++]=x;
        Arrays.sort(a);
        //处理到第i个数字时能获得的最大伤害
        long[] dp=new long[n];
        dp[0]=1L*a[0]*hash.get(a[0]);
        int j=0;//指向最后一个与i冲突的位置
        for(int i=1;i<n;i++){
            int x=a[i];//获取当前伤害值
            while(a[j]<x-2) j++;
            //记录选择x时前面能得到的最大贡献
            long maxC=j-1>=0?dp[j-1]:0;
            dp[i]=Math.max(dp[i-1],maxC+1L*x*hash.get(x));
        }
        return dp[n-1];
    }
    
}
