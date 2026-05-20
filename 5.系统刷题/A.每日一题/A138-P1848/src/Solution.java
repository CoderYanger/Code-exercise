/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-18
 * Time: 20:51
 */
class Solution {
    //1848. 到目标元素的最小距离
    //写法一：从左到右遍历
    public int getMinDistance(int[] nums, int target, int start) {
        int ret=0x3f3f3f3f;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==target) ret=Math.min(ret,Math.abs(i-start));
        return ret;
    }

    //写法二：从start往两边遍历
    public int getMinDistance(int[] nums, int target, int start) {
        for(int k=0;;k++)
            if(start>=k&&nums[start-k]==target||start+k<nums.length&&nums[start+k]==target)
                return k;
    }

}
