import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-30
 * Time: 17:16
 */
class Solution {
    //560. 和为K的子数组
    /*给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
    子数组是数组中元素的连续非空序列。
    示例 1：
    输入：nums = [1,1,1], k = 2
    输出：2
    示例 2：
    输入：nums = [1,2,3], k = 3
    输出：2
    提示：
            1 <= nums.length <= 2 * 104
            -1000 <= nums[i] <= 1000
            -107 <= k <= 107*/
    //滑动窗口解法（不通过，因为无法解决有负数的数组）
    /*public int subarraySum(int[] nums, int k) {
        int n=nums.length,count=0;
        if(n==1&&nums[0]!=k) return 0;
        for(int left=0,right=0,sum=0;right<n;right++){
            if(sum<k) sum+=nums[right];
            while(left<=right&&sum>k) sum-=nums[left++];
            if(sum==k) count++;
        }
        return count;
    }*/
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int sum=0,ret=0;
        hash.put(0,1);
        for(int x:nums){
            sum+=x;//计算当前位置的前缀和
            ret+=hash.getOrDefault(sum-k,0);//统计结果
            hash.put(sum,hash.getOrDefault(sum,0)+1);//将当前位置的前缀和丢进哈希表中
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,3,-1,4,0,5,-2};
        int k=5;
        Solution solution=new Solution();
        int count = solution.subarraySum(nums, k);
        System.out.println(count);
    }
}