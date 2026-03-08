import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 08:32
 */
class Solution {
    //3010. 将数组分成最小总代价的子数组 I
    //解法一：直接排序
    public int minimumCost(int[] nums) {
        Arrays.sort(nums,1,nums.length);
        return nums[0]+nums[1]+nums[2];
    }
    //解法二：维护最小值和次最小值
    public int minimumCost(int[] nums) {
        int min=0x3f3f3f3f,smin=0x3f3f3f3f;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                smin=min;
                min=nums[i];
            }else if(nums[i]<smin) smin=nums[i];
        }
        return nums[0]+min+smin;
    }
}