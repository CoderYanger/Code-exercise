import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-14
 * Time: 15:05
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i])) return true;//map用的是containsKey
            else hash.add(nums[i]);//map用的是put
        }
        return false;
    }
}
