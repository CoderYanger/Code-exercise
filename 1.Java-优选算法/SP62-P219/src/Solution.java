import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-14
 * Time: 15:22
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //自己按照吴小哲的思路，一气呵成
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hash.containsKey(nums[i])) hash.put(nums[i],i);
            else{
                if(i-hash.get(nums[i])<=k) return true;
                else hash.put(nums[i],i);//直接覆盖
            }
        }
        return false;
    }
}
