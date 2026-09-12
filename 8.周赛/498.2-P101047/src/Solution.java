/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-19
 * Time: 13:38
 */
class Solution {
    //101047. 最小稳定下标 II
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        if(n==1) return 0<=k?0:-1;
        int[] max=new int[n];
        max[0]=nums[0];
        int[] min=new int[n];
        min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) min[i]=Math.min(nums[i],min[i+1]);
        for(int i=0;i<n;i++){
            if(i>0) max[i]=Math.max(nums[i],max[i-1]);
            if(max[i]-min[i]<=k) return i;
        }
        return -1;
    }
}
