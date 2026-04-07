import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-11
 * Time: 14:57
 */
class Solution {
    //3804. 中心子数组的数量
    public int centeredSubarrays(int[] nums) {
        int n=nums.length,ret=0;
        for(int i=0;i<n;i++){
            int sum=0;
            Set<Integer> hash=new HashSet<>();
            for(int j=i;j<n;j++){
                hash.add(nums[j]);
                sum+=nums[j];
                if(hash.contains(sum)) ret++;
            }
        }
        return ret;
    }
}