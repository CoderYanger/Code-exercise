/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-19
 * Time: 19:43
 */
class Solution {
    //643. 子数组最大平均数 I
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int ret=-0x3f3f3f;
        int sum=0;//统计窗口内的总和
        for(int right=0;right<n;right++){
            //入窗口
            sum+=nums[right];
            int left=right-k+1;
            //当定长窗口还未形成时，持续入窗口
            if(left<0) continue;
            //更新
            ret=Math.max(ret,sum);
            //出窗口
            sum-=nums[left];
        }
        return (double)ret/k;
    }
}