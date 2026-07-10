/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-07
 * Time: 21:24
 */
class Solution {
    //3633. 最早完成陆地和水上游乐设施的时间 I
    //3635. 最早完成陆地和水上游乐设施的时间 II
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landWater=slove(landStartTime,landDuration,waterStartTime,waterDuration);
        int waterLand=slove(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(landWater,waterLand);
    }
    private int slove(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration){
        int minFinish=0x3f3f3f3f;
        for(int i=0;i<landStartTime.length;i++)
            minFinish=Math.min(minFinish,landStartTime[i]+landDuration[i]);
        int ret=0x3f3f3f3f;
        for(int i=0;i<waterStartTime.length;i++)
            ret=Math.min(ret,Math.max(waterStartTime[i],minFinish)+waterDuration[i]);
        return ret;
    }
}
