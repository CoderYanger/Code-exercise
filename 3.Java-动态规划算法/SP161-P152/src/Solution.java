/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-22
 * Time: 15:56
 */
class Solution {
    //152. 乘积最大子数组
    //看完算法原理自己没写出来，但是看完吴小哲写的又找不出错，好像确实是这回事
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[] f=new int[n+1];
        int[] g=new int[n+1];
        f[0]=g[0]=1;
        int ret=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int x=nums[i-1],y=f[i-1]*nums[i-1],z=g[i-1]*nums[i-1];
            f[i]=Math.max(x,Math.max(y,z));
            g[i]=Math.min(x,Math.min(y,z));
            ret=Math.max(ret,f[i]);
        }
        return ret;
    }
}
