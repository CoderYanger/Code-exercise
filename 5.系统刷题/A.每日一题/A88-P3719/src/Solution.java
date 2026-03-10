import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-11
 * Time: 12:57
 */
class Solution {
    //3719. 最长平衡子数组 I
    public int longestBalanced(int[] nums) {
        int len=0;
        for(int i=0;i<nums.length;i++){
            //判断以i开头的子数组是否符合条件
            HashMap<Integer,Integer> even=new HashMap<>();//计数偶数
            HashMap<Integer,Integer> odd=new HashMap<>();//计数奇数
            for(int j=i;j<nums.length;j++){
                HashMap<Integer,Integer> hash=(nums[j]%2==0)?even:odd;
                hash.put(nums[j],hash.getOrDefault(nums[j],0)+1);
                if(even.size()==odd.size()) len=Math.max(len,j-i+1);
            }
        }
        return len;
    }
}