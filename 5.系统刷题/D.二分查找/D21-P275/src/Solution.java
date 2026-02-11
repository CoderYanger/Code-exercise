/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-05
 * Time: 19:46
 */
class Solution {
    //275. H 指数 II
    //写法一：最左端点模型
    public int hIndex(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,nums)) left=mid+1;
            else right=mid;
        }
        return nums[left]>=n-left?n-left:0;
    }
    //判断当前位置引用数是否不足
    private boolean check(int mid,int[] nums){
        if(nums[mid]<nums.length-mid) return true;
        return false;
    }

    //写法二：最右端点模型
    public int hIndex(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(check(mid,nums)) right=mid-1;
            else left=mid;
        }
        //如果当前位置右越界，在保证不越界的情况下尝试返回前一个
        return nums[left]>=n-left?n-left:Math.max(n-left-1,0);
    }
    //判断当前位置引用数是否过量
    private boolean check(int mid,int[] nums){
        if(nums[mid]>nums.length-mid) return true;
        return false;
    }
}
