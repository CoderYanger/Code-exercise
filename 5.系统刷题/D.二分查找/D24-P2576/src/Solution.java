import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-06
 * Time: 20:34
 */
class Solution {
    //解法一：排序+双指针+贪心
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=(n+1)/2;
        int ret=0;
        while(left<n/2&&right<n){
            if(2*nums[left]<=nums[right]){
                ret+=2;
                left++;right++;
            }else right++;
        }
        return ret;
    }

    //解法二：二分查找
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=n/2;
        int ret=0;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(check(mid,nums)) right=mid-1;
            else left=mid;
        }
        return left*2;
    }
    //如果不能找到mid对则说明mid太大了，返回true，需要向左调整
    private boolean check(int mid,int[] nums){
        //0对一定可行，无需向更小调整
        if(mid==0) return false;
        int n=nums.length;
        //贪心验证：前mid个最小元素配对最后mid个最大元素
        for(int i=0;i<mid;i++)
            //有一个不满足，mid对就达不到
            if(2*nums[i]>nums[n-mid+i]) return true;
        return false;
    }
}
