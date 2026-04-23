/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-11
 * Time: 13:48
 */
class Solution {
    //2321. 拼接数组的最大分数
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1,nums2),solve(nums2,nums1));
    }
    private int solve(int[] nums1,int[]nums2){
        //空间优化版
        int n=nums1.length;
        int sum=nums1[0];
        int dp=Math.max(nums2[0]-nums1[0],0);
        int max=dp;
        for(int i=1;i<n;i++){
            sum+=nums1[i];
            dp=Math.max(dp,0)+nums2[i]-nums1[i];
            max=Math.max(max,dp);
        }
        return sum+max;
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1,nums2),solve(nums2,nums1));
    }
    private int solve(int[] nums1,int[]nums2){
        //进阶空间优化
        int n=nums1.length;
        int sum=0,dp=0,max=0;
        for(int i=0;i<n;i++){
            sum+=nums1[i];
            dp=Math.max(dp,0)+nums2[i]-nums1[i];
            max=Math.max(max,dp);
        }
        return sum+max;
    }
}