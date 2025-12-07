/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-20
 * Time: 20:30
 */
class Solution {
    //918. 环形子数组的最大和
    //看完算法原理后自己写的，一遍过
    //吴小哲跟我写的基本一样
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums) sum+=x;
        int[] f=new int[n+1];
        int[] g=new int[n+1];
        int fmax=Integer.MIN_VALUE;
        int gmin=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            f[i]=Math.max(nums[i-1],nums[i-1]+f[i-1]);
            fmax=Math.max(fmax,f[i]);
            g[i]=Math.min(nums[i-1],nums[i-1]+g[i-1]);
            gmin=Math.min(gmin,g[i]);
        }
        return sum==gmin?fmax:Math.max(fmax,sum-gmin);
    }
}