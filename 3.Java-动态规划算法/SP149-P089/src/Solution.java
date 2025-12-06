/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-16
 * Time: 22:47
 */
class Solution {
    //LCR089. 打家劫舍
    //跟面试题17.16按摩师是一样的
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int[] f=new int[n];
        int[] g=new int[n];
        g[0]=0;
        f[0]=nums[0];
        for(int i=1;i<n;i++){
            f[i]=g[i-1]+nums[i];
            g[i]=Math.max(f[i-1],g[i-1])+0;
        }
        return Math.max(g[n-1],f[n-1]);

    }
}