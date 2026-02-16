import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-27
 * Time: 18:16
 */
class Solution {
    //3381. 长度可被 K 整除的子数组的最大元素和
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        //计算前缀和
        long[] sum=new long[n+1];
        //后续j-i作差时取的区间是[i,j-1]
        for(int i=0;i<n;i++) sum[i+1]=sum[i]+nums[i];
        long ret= Long.MIN_VALUE;//参与后续取最大了，要初始化很小的值
        //计算同余的最小值数组
        long[] mins=new long[k];//余数范围0~k-1
        //由于mins参与后续更新最小值，所以要初始化为最大值
        //又因为mins要参与减数，防止溢出，所以初始化为最大值的一半
        Arrays.fill(mins,Long.MAX_VALUE/2);
        for(int j=0;j<n+1;j++){
            int i=j%k;
            //因为一开始计算差值的时候取不到j，区间是[i,j-1]，所以后更新mins
            ret=Math.max(ret,sum[j]-mins[i]);
            mins[i]=Math.min(mins[i],sum[j]);
        }
        return ret;
    }

    public long maxSubarraySum2(int[] nums, int k) {
        //一边计算前缀和一边维护mins
        int n=nums.length;
        long[] mins=new long[k];
        //这里前缀和从sum[-1]=0开始，由于-1与k-1%k后同余，所以初始化mins[k-1]=0,也就是一开始直接让mins[k-1]代替sum[-1]取值了
        //初始化区间[i,k-1)为最大值的一半，具体是区间[0,k-2]
        Arrays.fill(mins,0,k-1,Long.MAX_VALUE/2);
        long sum=0,ret=Long.MIN_VALUE;
        for(int j=0;j<n;j++){
            sum+=nums[j];
            int i=j%k;//第一次进来时直接让mins[k-1]代替sum[-1]取值了
            ret=Math.max(ret,sum-mins[i]);
            mins[i]=Math.min(mins[i],sum);
        }
        return ret;
    }
}