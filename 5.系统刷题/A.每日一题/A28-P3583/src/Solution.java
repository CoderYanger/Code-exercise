import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-09
 * Time: 22:19
 */
class Solution {
    //3583. 统计特殊三元组
    public int specialTriplets(int[] nums) {
        int n=nums.length,MOD=1_000_000_007;
        long ret=0;
        Map<Integer,Integer> suf=new HashMap<>();
        Map<Integer,Integer> pre=new HashMap<>();
        for(int i=1;i<n;i++) suf.put(nums[i],suf.getOrDefault(nums[i],0)+1);
        for(int j=1;j<n;j++){
            pre.put(nums[j-1],pre.getOrDefault(nums[j-1],0)+1);
            suf.put(nums[j],suf.get(nums[j])-1);
            int left=pre.getOrDefault(nums[j]*2,0);
            int right=suf.getOrDefault(nums[j]*2,0);
            ret=(ret+(long)left*right)%MOD;
        }
        return (int)ret;
    }
}