import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-25
 * Time: 21:52
 */
class Solution {
    //719. 找出第 K 小的数对距离
    //解法：二分查找+双指针
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0,right=nums[nums.length-1]-nums[0];
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,nums,k)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(int mid,int[] nums,int k){
        int cnt=0,i=0;
        for(int j=0;j<nums.length;j++){
            while(nums[j]-nums[i]>mid) i++;
            cnt+=j-i;
            //提前满足，提前返回
            if(cnt>k) return true;
        }
        return cnt>=k;
    }
}
