/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-05
 * Time: 12:12
 */
class Solution {
    //3701. 交替数字和
    public int alternatingSum(int[] nums) {
        int dsum=0,ssum=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) dsum+=nums[i];
            else ssum+=nums[i];
        }
        return dsum-ssum;
    }
}
