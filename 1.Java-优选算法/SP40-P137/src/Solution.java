import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-03
 * Time: 14:38
 */
class Solution {
    //137. 只出现一次的数字 II
    /*给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
    示例 1：
    输入：nums = [2,2,3,2]
    输出：3
    示例 2：
    输入：nums = [0,1,0,1,0,1,99]
    输出：99
    提示：
            1 <= nums.length <= 3 * 104
            -231 <= nums[i] <= 231 - 1
    nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次*/
    public int singleNumber1(int[] nums) {
        //用哈希表硬写
        Map<Integer,Integer> hash= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        for(Integer key:hash.keySet()) if(hash.get(key)==1) return key;
        return 0;
    }
    public int singleNumber2(int[] nums) {
        int ret=0;
        for(int i=0;i<32;i++){//修改ret的每一个比特位
            int sum=0;
            for(int x:nums)//依次统计nums中各数的和
                if(((x>>i)&1)==1) sum++;
            sum%=3;
            if(sum==1) ret|=(sum<<i);
        }
        return ret;
    }
}
