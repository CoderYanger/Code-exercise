/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-20
 * Time: 23:08
 */
class Solution {
    //1343. 大小为 K 且平均值大于等于阈值的子数组数目
    public int numOfSubarrays(int[] nums, int k, int t) {
        int n=nums.length;
        int ret=0,sum=0;
        for(int right=0;right<n;right++){
            //入窗口
            sum+=nums[right];
            int left=right-k+1;
            //还未形成长度为k的窗口就持续入窗口
            if(left<0) continue;
            //此时窗口长度已经为k了
            int avg=sum/k;
            if(avg>=t) ret++;
            //出窗口
            sum-=nums[left];
        }
        return ret;
    }
}