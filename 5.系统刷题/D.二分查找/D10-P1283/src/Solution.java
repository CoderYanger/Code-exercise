/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-16
 * Time: 23:39
 */
class Solution {
    //1283. 使结果不超过阈值的最小除数
    public int smallestDivisor(int[] nums, int t) {
        //除数不能是0，所以left初始化为1
        int left=1,right=0;
        for(int x:nums) right=Math.max(x,right);
        //找除数最小：最左端点模型
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(nums,mid,t)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(int[] nums,int mid,int t){
        int sum=0;
        for(int x:nums){
            //+mid-1：补足余数，完成向上取整
            sum+=(x+mid-1)/mid;
            if(sum>t) return false;
        }
        return true;
    }
}
