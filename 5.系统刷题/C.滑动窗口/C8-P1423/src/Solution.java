/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 11:00
 */
class Solution {
    //1423. 可获得的最大点数
    public int maxScore(int[] nums, int kk) {
        //解法：滑动窗口
        //问题转换：窗口长度：n-k，找窗口内的最小值
        int n=nums.length;
        int k=n-kk,ret=0x3f3f3f3f,sum=0;
        int total=0;
        for(int x:nums) total+=x;
        if(k==0) return total;
        for(int right=0;right<n;right++){
            int left=right-k+1;
            //进窗口
            sum+=nums[right];
            if(left<0) continue;
            //更新
            ret=Math.min(ret,sum);
            //出窗口
            sum-=nums[left];
        }
        return total-ret;
    }
}