import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-09-03
 * Time: 15:58
 */
class Solution {
    //2996. 大于等于顺序前缀和的最小缺失整数
    public int missingInteger(int[] nums) {
        int ret=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1) ret+=nums[i];
            else break;
        }
        //利用 Set 确认是否nums中存在对应元素
        Set<Integer> hash=new HashSet<>();
        for(int x:nums) hash.add(x);
        while(hash.contains(ret)) ret++;
        return ret;
    }
}
