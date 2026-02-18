/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-10
 * Time: 16:28
 */
class Solution {
    //3577. 统计计算机解锁顺序排列数
    public int countPermutations(int[] nums) {
        long ret=1;
        int n=nums.length,MOD=1_000_000_007;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[0]) return 0;
            ret=(ret*i)%MOD;
        }
        return (int)ret;
    }
}