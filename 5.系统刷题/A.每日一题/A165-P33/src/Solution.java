/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-25
 * Time: 18:05
 */
class Solution {
    //33. 搜索旋转排序数组
    public int search(int[] nums, int target) {
        //找到偏移量：可以看成向右旋转k个
        int k=findMin(nums);
        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            //找到原有序数组时的下标
            int index=(k+mid)%n;
            if(nums[index]<target) left=mid+1;
            else right=mid;
        }
        int index=(left+k)%n;
        return nums[index]==target?index:-1;
    }
    //153. 寻找旋转排序数组中的最小值
    private int findMin(int[] nums){
        int left=0,right=nums.length-1;
        //如果没有旋转，第一个就是最小元素
        if(nums[left]<=nums[right]) return 0;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]<nums[0]) right=mid-1;
            else left=mid;
        }
        return left+1;
    }
}
