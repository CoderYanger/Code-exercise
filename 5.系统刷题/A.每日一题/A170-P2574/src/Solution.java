/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-06
 * Time: 23:54
 */
class Solution {
    //2574. 左右元素和的差值
    //三次遍历
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] rightSum=new int[n];
        for(int i=n-2;i>=0;i--)
            rightSum[i]=rightSum[i+1]+nums[i+1];
        int[] leftSum=new int[n];
        for(int i=1;i<n;i++)
            leftSum[i]=leftSum[i-1]+nums[i-1];
        for(int i=0;i<n;i++)
            nums[i]=Math.abs(leftSum[i]-rightSum[i]);
        return nums;
    }

    //优化：两次遍历
    public int[] leftRightDifference(int[] nums) {
        int sum=0;
        for(int x:nums) sum+=x;
        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            int x=nums[i];//取出值，避免后续拿到被覆盖的值
            nums[i]=Math.abs(leftSum*2+x-sum);
            leftSum+=x;
        }
        return nums;
    }
    
}