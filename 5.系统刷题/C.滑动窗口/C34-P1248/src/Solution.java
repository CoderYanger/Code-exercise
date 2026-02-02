/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-11
 * Time: 23:33
 */
class Solution {
    //1248. 统计「优美子数组」
    //解法一：两个至多相减
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    private int solve(int[] nums,int k){
        int n=nums.length,ret=0,count=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            if(nums[right]%2==1) count++;
            //出窗口
            while(left<=right&&count>k)
                if(nums[left++]%2==1) count--;
            //更新
            ret+=right-left+1;
        }
        return ret;
    }

    //解法二：两个至少相减
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k+1);
    }
    private int solve(int[] nums,int k){
        int n=nums.length,ret=0,count=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            if(nums[right]%2==1) count++;
            //出窗口
            while(left<=right&&count>=k)
                if(nums[left++]%2==1) count--;
            //更新
            ret+=left;
        }
        return ret;
    }
}