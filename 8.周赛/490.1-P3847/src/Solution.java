/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-22
 * Time: 16:01
 */
class Solution {
    //3847. 计算比赛分数差
    public int scoreDifference(int[] nums) {
        int n=nums.length;
        int sum1=0,sum2=0;
        boolean mark=true;//true为第一位玩家，否则为第二位玩家
        for(int i=0;i<n;i++){
            //换角色
            if(nums[i]%2==1&&(i+1)%6!=0||nums[i]%2!=1&&(i+1)%6==0) mark=!mark;
            if(mark) sum1+=nums[i];
            else sum2+=nums[i];
        }
        return sum1-sum2;
    }
}
