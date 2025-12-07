/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-22
 * Time: 21:11
 */
class Solution {
    //413.等差数列划分
    //看完算法原理后自己写的，一遍过
    //吴小哲跟我写的一样
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=2;i<n;i++){
            int a=nums[i-2],b=nums[i-1],c=nums[i];
            dp[i]=c-b==b-a?dp[i-1]+1:0;
        }
        int ret=0;
        for(int x:dp) ret+=x;
        return ret;
    }
}