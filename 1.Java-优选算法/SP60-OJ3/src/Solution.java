import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-14
 * Time: 14:47
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //按照吴小哲的思路自己写的
        Map<Integer,Integer> hash =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int search=target-nums[i];
            if(!hash.containsKey(search)) hash.put(nums[i],i);
            else return new int[]{i,hash.get(search)};
        }
        return new int[0];
    }
}
