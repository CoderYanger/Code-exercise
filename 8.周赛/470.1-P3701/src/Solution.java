/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:50
 */
class Solution {
    //3701. 计算交替和
    public int alternatingSum(int[] nums) {
        int dsum=0,ssum=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) dsum+=nums[i];
            else ssum+=nums[i];
        }
        return dsum-ssum;
    }
}