import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-31
 * Time: 20:05
 */
class Solution {
    //525. 连续数组
    /*给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，
    并返回该子数组的长度。
    示例 1：
    输入：nums = [0,1]
    输出：2
    说明：[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
    示例 2：
    输入：nums = [0,1,0]
    输出：2
    说明：[0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
    示例 3：
    输入：nums = [0,1,1,1,1,1,0,0,0]
    输出：6
    解释：[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。
    提示：
            1 <= nums.length <= 105
    nums[i] 不是 0 就是 1*/

    //自己写的，有些漏洞
    /*public int findMaxLength(int[] nums) {
        int[] hash=new int [2];
        int count=0;
        for(int x:nums){
            if(x==0) hash[0]++;
            if(x==1) hash[1]++;
            if(hash[0]==hash[1]) count++;
        }
        return 2*count;
    }*/
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);
        int sum=0,ret=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==0?-1:1);//sum=-1和0和1在哈希表中均有记录
            if(hash.containsKey(sum)) ret=Math.max(ret,i-hash.get(sum));//然后根据sum相同用最后的减去第一个sum，逐次更新最大值
            else hash.put(sum,i);//这里只会第一次的时候进入，由于第一次出现的位置就是后面最长的位置，所以后续的就不用更新了
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] nums={0,1,0};
        Solution solution=new Solution();
        int ret=solution.findMaxLength(nums);
        System.out.println(ret);
    }
}