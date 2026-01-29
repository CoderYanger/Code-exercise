import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-10
 * Time: 22:47
 */
class Solution {
    //2799. 统计完全子数组的数目
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        //统计整个数组不同元素的个数
        Set<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);
        //统计<数，出现次数>
        Map<Integer,Integer> hash=new HashMap<>();
        int left=0,ret=0;
        for(int x:nums){
            //进窗口
            hash.put(x,hash.getOrDefault(x,0)+1);
            //出窗口
            while(hash.keySet().size()==set.size()){
                hash.put(nums[left],hash.get(nums[left])-1);
                if(hash.get(nums[left])==0) hash.remove(nums[left]);
                left++;
            }
            //更新
            ret+=left;
        }
        return ret;
    }
}