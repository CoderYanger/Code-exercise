import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-22
 * Time: 16:25
 */
class Solution {
    //2461. 长度为 K 子数组中的最大和
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long ret=0,sum=0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int right=0;right<n;right++){
            int in=nums[right];
            sum+=in;
            //入窗口
            hash.put(in,hash.getOrDefault(in,0)+1);
            int left=right-k+1;
            if(left<0) continue;
            //更新
            if(hash.keySet().size()==k) ret=Math.max(ret,sum);
            //出窗口
            int out=nums[left];
            sum-=out;
            hash.put(out,hash.get(out)-1);
            if(hash.get(out)==0) hash.remove(out);
        }
        return ret;
    }
}