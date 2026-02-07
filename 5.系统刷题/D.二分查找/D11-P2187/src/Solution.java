/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-17
 * Time: 13:00
 */
class Solution {
    //2187. 完成旅途的最少时间
    public long minimumTime(int[] nums, int t) {
        int n=nums.length;
        //求最少时间，最左端点模型
        //题目以规定t>1,那么left要初始化为1，因为时间为0时，趟数为0
        long left=0,right=0,max=0;
        //找到单趟时间需要最长的时间
        for(int x:nums) max=Math.max(max,x);
        //计算绝对上界，right要保证最慢的车也能走完t趟
        right=max*t;
        while(left<right){
            long mid=left+(right-left)/2;
            //如果在最左端的左侧：越往左时间越短，趟数越少，越不达标
            if(!check(nums,mid,t)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断在mid时刻，趟数是否达标
    private boolean check(int[] nums,long mid,int t){
        //获取该mid时刻的趟数
        long sum=0;
        for(int x:nums) sum+=mid/x;
        if(sum>=t) return true;
        return false;
    }
}
