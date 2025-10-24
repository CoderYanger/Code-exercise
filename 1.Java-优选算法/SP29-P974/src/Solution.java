import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-31
 * Time: 15:03
 */
class Solution {
    //974. 和可被 K 整除的子数组
    /*给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
    子数组 是数组中 连续 的部分。
    示例 1：
    输入：nums = [4,5,0,-2,-3,1], k = 5
    输出：7
    解释：
    有 7 个子数组满足其元素之和可被 k = 5 整除：
            [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    示例 2:
    输入: nums = [5], k = 9
    输出: 0
    提示:
            1 <= nums.length <= 3 * 104
            -104 <= nums[i] <= 104
            2 <= k <= 104*/

    //暴力解法，会超时
    //时间复杂度：O(n^2)
    //空间复杂度：O(1)
    /*public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum%k==0) count++;
            }
        }
        return count;
    }*/
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> hash=new HashMap<>();
        int sum=0,ret=0;
        hash.put(0%k,1);
        for(int x:nums){
            sum+=x;
            ret+=hash.getOrDefault((sum%k+k)%k,0);
            hash.put((sum%k+k)%k,hash.getOrDefault((sum%k+k)%k,0)+1);
        }
        return ret;
    }
}