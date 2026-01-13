import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 11:31
 */
class Solution {
    //1695. 删除子数组的最大得分
    public int maximumUniqueSubarray(int[] nums) {
        //问题转化：滑动窗口内的元素不重复，找和的最大值
        Set<Integer> hash=new HashSet<>();
        int n=nums.length,sum=0,ret=0;
        for(int right=0,left=0;right<n;right++){
            int in=nums[right];
            //出窗口
            while(hash.contains(in)){
                sum-=nums[left];
                hash.remove(nums[left++]);
            }
            //进窗口
            sum+=in;
            hash.add(in);
            //更新
            ret=Math.max(ret,sum);
        }
        return ret;
    }
}