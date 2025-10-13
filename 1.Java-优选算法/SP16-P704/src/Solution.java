/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-27
 * Time: 18:06
 */
class Solution {
    /*public int search(int[] nums, int target) {
        return search2(nums,0,nums.length,target);
    }
    public static int search2(int[] nums,int left,int right,int target){
        int mid=(left+right)/2;
        if(nums[mid]==target) return mid;
        else if(target<nums[mid]) return search2(nums,0,mid,target);
        else if(target>nums[mid]) return search2(nums,mid+1,right,target);
        else return -1;
    }*/

    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) right=mid-1;
            else if(nums[mid]<target) left=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println(new Solution().search(nums,9));
    }
}
