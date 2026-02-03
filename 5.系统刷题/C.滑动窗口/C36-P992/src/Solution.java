import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-12
 * Time: 20:04
 */
class Solution {
    //992. K 个不同整数的子数组
    //解法一：两个至多相减（ret+=right-left+1型）
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    private int solve(int[] nums,int k){
        int ret=0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int left=0,right=0;right<nums.length;right++){
            //进窗口
            hash.put(nums[right],hash.getOrDefault(nums[right],0)+1);
            //出窗口
            while(hash.keySet().size()>k){
                hash.put(nums[left],hash.get(nums[left])-1);
                if(hash.get(nums[left])==0) hash.remove(nums[left]);
                left++;
            }
            //更新
            ret+=right-left+1;
        }
        return ret;
    }
    //解法二：两个至少相减（ret+=left型）
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k+1);
    }
    private int solve(int[] nums,int k){
        int ret=0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int left=0,right=0;right<nums.length;right++){
            //进窗口
            hash.put(nums[right],hash.getOrDefault(nums[right],0)+1);
            //出窗口
            while(hash.keySet().size()==k){
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