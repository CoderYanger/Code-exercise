import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 16:19
 */
class Solution {
    //3852. 不同频率的最小数对
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<=2) return new int[]{-1,-1};
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums) hash.put(x,hash.getOrDefault(x,0)+1);
        int val=0;
        int key=0;
        for(int x:nums){
            if(key==0) key=x;
            if(val==0) val=hash.get(x);
            else if(val!=hash.get(x)) return new int[]{Math.min(key,x),Math.max(key,x)};
        }
        return new int[]{-1,-1};
    }
}
