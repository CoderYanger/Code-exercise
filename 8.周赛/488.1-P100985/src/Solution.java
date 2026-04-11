/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-08
 * Time: 13:22
 */
class Solution {
    //100985. 统计主导元素下标数
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int ret=0;
        //suff[i]:i下标及后面所有元素的和
        int[] suff=new int[n];
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) suff[i]=nums[i]+suff[i+1];
        for(int i=0;i<n-1;i++)
            if((double)nums[i]>(double)suff[i+1]/(n-1-i))
                ret++;
        return ret;
    }
}
