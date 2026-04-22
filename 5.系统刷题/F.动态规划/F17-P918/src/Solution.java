/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 17:28
 */
class Solution {
    //918.环形子数组的最大和
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums) sum+=x;
        //f[i]:以i位置结尾的子数组的最大值
        int[] f=new int[n];
        f[0]=nums[0];
        //g[i]:以i位置结尾的子数组的最小值
        int[] g=new int[n];
        g[0]=nums[0];
        int fmax=f[0],gmin=g[0];
        for(int i=1;i<n;i++){
            f[i]=Math.max(f[i-1],0)+nums[i];
            fmax=Math.max(fmax,f[i]);
            g[i]=Math.min(g[i-1],0)+nums[i];
            gmin=Math.min(gmin,g[i]);
        }
        return sum==gmin?fmax:Math.max(fmax,sum-gmin);
    }

    //空间优化版
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums) sum+=x;
        int f=nums[0];
        int g=nums[0];
        int fmax=f,gmin=g;
        for(int i=1;i<n;i++){
            f=Math.max(f,0)+nums[i];
            fmax=Math.max(fmax,f);
            g=Math.min(g,0)+nums[i];
            gmin=Math.min(gmin,g);
        }
        return sum==gmin?fmax:Math.max(fmax,sum-gmin);
    }

    //进阶空间优化版
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums) sum+=x;
        int f=0,g=0;
        int fmax=nums[0],gmin=nums[0];
        for(int x:nums){
            f=Math.max(f,0)+x;
            fmax=Math.max(fmax,f);
            g=Math.min(g,0)+x;
            gmin=Math.min(gmin,g);
        }
        return sum==gmin?fmax:Math.max(fmax,sum-gmin);
    }
    
}
