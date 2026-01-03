/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-28
 * Time: 12:19
 */
class Solution {
    //3788. 分割的最大得分
    public long maximumScore(int[] nums) {
        int n=nums.length;
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        long[] suffix=new long[n];
        suffix[n-1]=nums[n-1];
        long ret=Long.MIN_VALUE;
        for(int i=1;i<n;i++) prefix[i]=prefix[i-1]+nums[i];
        for(int i=n-2;i>=0;i--) suffix[i]=Math.min(suffix[i+1],nums[i]);
        for(int i=0;i<n-1;i++) ret=Math.max(ret,prefix[i]-suffix[i+1]);
        return ret;
    }
}