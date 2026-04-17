import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-05
 * Time: 22:25
 */
class Solution {
    //3795. 不同元素和至少为 K 的最短子数组长度
    public int minLength(int[] nums, int k) {
        //滑动窗口
        Map<Integer,Integer> hash=new HashMap<>();
        int n=nums.length,sum=0,ret=0x3f3f3f3f;
        for(int left=0,right=0;right<n;right++){
            //相同值只加一次
            if(!hash.containsKey(nums[right])) sum+=nums[right];
            //进窗口
            hash.put(nums[right],hash.getOrDefault(nums[right],0)+1);
            //出窗口
            while(sum>=k){
                //更新:出窗口时不断缩小范围更新
                if(sum>=k) ret=Math.min(ret,right-left+1);
                hash.put(nums[left],hash.get(nums[left])-1);
                if(hash.get(nums[left])==0){
                    sum-=nums[left];
                    hash.remove(nums[left]);
                }
                left++;
            }
        }
        return ret==0x3f3f3f3f?-1:ret;
    }
}