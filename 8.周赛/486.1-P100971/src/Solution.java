/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-25
 * Time: 13:30
 */
class Solution {
    //100971. 移除前缀使数组严格递增
    public int minimumPrefixLength(int[] nums) {
        int left=-1,ret=0,n=nums.length;
        for(int right=1;right<n;right++){
            if(nums[right]<=nums[right-1]){
                ret+=right-1-left;
                //让left停留在第一次出现下破或平坡的坡前
                //用作减数，完成差值计算
                left=right-1;
            }
        }
        return ret;
    }
}
