import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-09-03
 * Time: 15:59
 */
class Solution {
    //3471. 找出最大的几近缺失整数
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> hash=new HashMap<>();
        //提前存储最大值
        int mx=-0x3f3f3f3f;
        for(int x:nums){
            mx=Math.max(mx,x);
            hash.merge(x,1,Integer::sum);
        }
        //①n<k：返回－1
        if(n<k) return -1;
        //②n==k：返回最大的
        if(n==k) return mx;
        //③k==1：返回唯一且最大的
        if(k==1){
            int mx2=-0x3f3f3f3f;
            for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
                if(entry.getValue()==1){
                    mx2=Math.max(mx2,entry.getKey());
                }
            }
            //没有唯一的，返回－1
            if(mx2==-0x3f3f3f3f) return -1;
            return mx2;
        }
        //④其他情况：返回首尾数之间唯一出现且最大的
        if(hash.get(nums[0])==1&&hash.get(nums[n-1])==1) return Math.max(nums[0],nums[n-1]);
        else if(hash.get(nums[0])==1) return nums[0];
        else if(hash.get(nums[n-1])==1)return nums[n-1];
        //都没有符合的，返回－1
        return -1;
    }
}
