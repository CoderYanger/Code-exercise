import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:54
 */
class Solution {
    //3712. 出现次数能被 K 整除的元素总和
    public int sumDivisibleByK(int[] nums, int k) {
        int sum=0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            if(entry.getValue()%k==0) {
                for(int i=0;i<entry.getValue();i++){
                    sum+=entry.getKey();
                }
            }
        }
        return sum;
    }
}