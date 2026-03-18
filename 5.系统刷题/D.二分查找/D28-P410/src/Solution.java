/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-12
 * Time: 19:53
 */
class Solution {
    //410. 分割数组的最大值
    public int splitArray(int[] nums, int k) {
        int left=0,right=0;
        for(int x:nums){
            left=Math.max(left,x);
            right+=x;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,nums,k)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断是否能将nums分割为≤k个子数组，且每个子数组的和都≤mid
    private boolean check(int mid,int[] nums, int k){
        //当前子数组累加和
        int sum=0;
        //子数组计数，初始为1（至少一个子数组）
        int cnt=1;
        for(int x:nums){
            if(sum+x<=mid){
                sum+=x;
                continue;
            }
            if(cnt==k) return false;
            cnt++;
            sum=x;
        }
        return true;
    }
}