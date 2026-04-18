/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 13:48
 */
class Solution {
    //3840. 打家劫舍 V
    public long rob(int[] nums, int[] colors) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        //初始化前一个状态：不抢劫和抢劫第0间房屋
        long prevnotrob=0;
        long prevrob=nums[0];
        for(int i=1;i<n;i++){
            //不抢劫当前房屋的最大金额
            long curnotrob=Math.max(prevnotrob,prevrob);
            //抢劫当前房屋的最大金额
            long currob;
            //颜色不同，前一个可抢可不抢
            if(colors[i]!=colors[i-1]) currob=Math.max(prevnotrob,prevrob)+nums[i];
                //颜色相同，前一个必须不抢
            else currob=prevnotrob+nums[i];
            //状态更新
            prevnotrob=curnotrob;
            prevrob=currob;
        }
        //最终结果是最后一个房屋 抢 或 不抢 的最大值
        return Math.max(prevnotrob,prevrob);
    }
}
