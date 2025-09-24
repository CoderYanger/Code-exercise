import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-11
 * Time: 20:00
 */
class Solution {
    //35. 搜索插入位置
    /*给定一个排序数组和一个目标值，在数组中找到目标值，
    并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。
    示例 1:
    输入: nums = [1,3,5,6], target = 5
    输出: 2
    示例 2:
    输入: nums = [1,3,5,6], target = 2
    输出: 1
    示例 3:
    输入: nums = [1,3,5,6], target = 7
    输出: 4
    提示:
            1 <= nums.length <= 104
            -104 <= nums[i] <= 104
    nums 为 无重复元素 的 升序 排列数组
-104 <= target <= 104*/

    //自己写的，多处错误
    /*public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length;
        if(!search(start,end,nums,target)){
            return search(start,end,nums,target);
        }else{
            return search2(start,end,nums,target);
        }
    }
    public static int search(int start,int end,int[]arr,int target){
        int mid=arr.length/2;
        if(target==arr[mid]){
            return mid;
        }
        if(target>mid){
            int str= Arrays.copyOfRange(arr,start,end);
            search(mid,end,str,target);
        }else if(target<mid){
            int str=Arrays.copyOfRange(arr,start,end);
            search(start,end,str,target);
        }
        return 0;
    }
    public static int search2(int start,int end,int[]arr,int target){
        int mid=arr.length/2;
        if(target>mid){
            if(target<mid){
                return mid-1;
            }
            int str=Arrays.copyOfRange(arr,start,end);
            search(mid,end,str,target);
        }else if(target<mid){
            if(target>mid){
                return mid;
            }
            int str=Arrays.copyOfRange(arr,start,end);
            search(start,end,str,target);
        }
    }*/

    //看总结的思维导图找到的Arrays.binarySearch方法=排序+二分查找
    //确实有点nb奥
    public int searchInsert1(int[] nums, int target) {
        if(Arrays.binarySearch(nums,target)>=0){
            return Arrays.binarySearch(nums,target);
        }else{
            return -(Arrays.binarySearch(nums,target)+1);
        }
    }
    public int searchInsert(int[] nums, int target) {
        return search(0,nums.length,nums,target);
    }
    //按照自己写的二分查找修改后的：
    public static int search(int start,int end,int[] arr,int target){
        //此时区间只剩下一个元素，包括了原数组没有这个数的情况
        if(start==end){
            return end;
        }
        int mid=(start+end)/2;
        if(target==arr[mid]){
            return mid;
        }
        if(target<arr[mid]){
            return search(start,mid,arr,target);
        }else{
            return search(mid+1,end,arr,target);
        }
    }
}
