import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 12:52
 */
class Solution {
    //2958. 最多 K 个重复元素的最长子数组
    public int maxSubarrayLength(int[] nums, int k) {
        //子数组连续->滑动窗口
        Map<Integer,Integer> hash=new HashMap<>();
        int n=nums.length,ret=0;
        for(int right=0,left=0;right<n;right++){
            //进窗口
            int in=nums[right];
            hash.put(in,hash.getOrDefault(in,0)+1);
            //更新
            if(hash.get(in)<=k) ret=Math.max(ret,right-left+1);
            //出窗口
            while(hash.get(in)>k){
                int out=nums[left];
                hash.put(out,hash.get(out)-1);
                if(hash.get(out)==0) hash.remove(out);
                left++;
            }
        }
        return ret;
    }
}