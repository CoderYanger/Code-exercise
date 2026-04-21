/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-09
 * Time: 23:36
 */
class Solution {
    //1749. 任意子数组和的绝对值的最大值
    //解法一：动态规划
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        //f[i]:以i位置结尾的子数组的和的最大值
        int[] f=new int[n];
        f[0]=nums[0];
        //g[i]:以i位置结尾的子数组的和的最小值
        int[] g=new int[n];
        g[0]=nums[0];
        int ret=Math.abs(nums[0]);
        for(int i=1;i<n;i++){
            f[i]=Math.max(f[i-1]+nums[i],nums[i]);
            g[i]=Math.min(g[i-1]+nums[i],nums[i]);
            ret=Math.max(ret,Math.max(Math.abs(f[i]),Math.abs(g[i])));
        }
        return ret;
    }

    //空间优化版
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int f=nums[0],g=nums[0];
        int ret=Math.abs(nums[0]);
        for(int i=1;i<n;i++){
            f=Math.max(f+nums[i],nums[i]);
            g=Math.min(g+nums[i],nums[i]);
            ret=Math.max(ret,Math.max(Math.abs(f),Math.abs(g)));
        }
        return ret;
    }

    //进阶空间优化
    public int maxAbsoluteSum(int[] nums) {
        int f=0,g=0;
        int ret=0;
        for(int x:nums){
            f=Math.max(f,0)+x;
            g=Math.min(g,0)+x;
            ret=Math.max(ret,Math.max(f,-g));
        }
        return ret;
    }

    //解法二：前缀和
    public int maxAbsoluteSum(int[] nums) {
        int s=0,max=0,min=0;
        for(int x:nums){
            s+=x;
            max=Math.max(s,max);
            min=Math.min(s,min);
        }
        return max-min;
    }
}