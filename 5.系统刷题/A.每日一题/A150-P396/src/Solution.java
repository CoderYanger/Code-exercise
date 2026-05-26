/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-10
 * Time: 17:19
 */
class Solution {
    //396. 旋转函数
    //解法一：暴力计算
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int ret=Integer.MIN_VALUE;
        int[] a=new int[2*n];
        for(int i=0;i<n;i++){
            a[i]=nums[i];
            a[i+n]=nums[i];
        }
        for(int i=0;i<n;i++) ret=Math.max(ret,F(a,i,n));
        return ret;
    }
    private int F(int[] a,int index,int n){
        int ret=0;
        for(int i=index,t=0;i<index+n;i++,t++) ret+=t*a[i];
        return ret;
    }

    //解法二：递推
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        long sum=0;
        long[] F=new long[n];
        for(int i=0;i<n;i++){
            F[0]+=i*nums[i];
            sum+=nums[i];
        }
        long ret=F[0];
        for(int i=1;i<n;i++){
            F[i]=F[i-1]+sum-n*nums[n-i];
            ret=Math.max(ret,F[i]);
        }
        return (int)ret;
    }

    //解法二：递推优化
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int sum=0;
        int F=0;
        for(int i=0;i<n;i++){
            F+=i*nums[i];
            sum+=nums[i];
        }
        int ret=F;
        for(int i=1;i<n;i++){
            F=F+sum-n*nums[n-i];
            ret=Math.max(ret,F);
        }
        return ret;
    }
}