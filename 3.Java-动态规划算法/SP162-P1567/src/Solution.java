/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-22
 * Time: 18:23
 */
class Solution {
    //1567. 乘积最大子数组长度
    //看完算法原理后自己写的，一遍过
    //吴小哲跟我写的一样
    public int getMaxLen(int[] nums) {
        int n=nums.length;
        int[] f=new int[n+1];
        int[] g=new int[n+1];
        int ret=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int x=g[i-1]==0?0:g[i-1]+1,y=f[i-1]+1;
            if(nums[i-1]>0){
                g[i]=x;
                f[i]=y;
            }else if(nums[i-1]<0){
                g[i]=y;
                f[i]=x;
            }
            ret=Math.max(ret,f[i]);
        }
        return ret;
    }
}