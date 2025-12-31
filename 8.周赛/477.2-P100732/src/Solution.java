import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-23
 * Time: 12:09
 */
class Solution {
    //100732. 最大平衡异或子数组的长度
    public int maxBalancedSubarray(int[] nums) {
        int tmp=0;//前缀异或和
        int diff=0;//奇偶差
        int ret=0;
        //哈希表存<”前缀异或，奇偶差“,首次出现的前缀索引>
        //当再次遇到相同的键时，说明tmp=0且奇偶数相同
        Map<String,Integer> hash=new HashMap<>();
        //记录初识状态
        hash.put("0,0",0);
        for(int i=0;i<nums.length;i++){
            //记录的是前k=i+1个元素的状态
            int x=nums[i];
            diff+=(x%2==1)?1:-1;
            tmp^=x;
            String s=tmp+","+diff;
            if(hash.containsKey(s))
                ret=Math.max(ret,i+1-hash.get(s));
            else
                //首次出现,直接扔进去
                hash.put(s,i+1);
        }
        return ret;
    }
}
