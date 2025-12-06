/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-16
 * Time: 22:50
 */
class Solution {
    //213. 打家劫舍 II
    //看完吴小哲的代码后，找到错误了
    //if(k>j) return 0;这里不是≥，就是＞
    //rod1的返回值是f[j]和g[j],传入的参数不是边界，而是实际能到的地方
    int n;
    //int[] f,g;移除全局变量，防止计算y时，x的计算结果的影响
    public int rob(int[] nums) {
        n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];//新增处
        //int[] f=new int[n];
        //int[] g=new int[n];
        //f[0]=nums[0];g[0]=0;
        //第一个偷
        int x=rob1(2,n-2,nums)+nums[0];
        //第一个不偷
        int y=rob1(1,n-1,nums);
        return Math.max(x,y);
    }
    public int rob1(int k,int j,int[] nums){
        if(k>j) return 0;
        int[] f=new int[n];
        int[] g=new int[n];
        f[k]=nums[k];g[k]=0;
        for(int i=k+1;i<=j;i++){
            f[i]=g[i-1]+nums[i];
            g[i]=Math.max(f[i-1],g[i-1]);
        }
        return Math.max(g[j],f[j]);
    }
}