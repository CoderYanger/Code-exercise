import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-23
 * Time: 22:34
 */
class Solution {
    //一开始的暴力枚举，时间复杂度O(N),会超时
    //2588. 统计美丽子数组数目
    public long beautifulSubarrays(int[] nums) {
        int n=nums.length;
        //记录前缀异或
        //xor[i]:前i个数的异或结果
        int[] xor=new int[n+1];
        for(int i=1;i<=n;i++) xor[i]=xor[i-1]^nums[i-1];
        //枚举所有子数组
        long cnt=0;
        for(int i=0;i<=n;i++)
            for(int j=i+1;j<=n;j++)
                if((xor[i]^xor[j])==0)
                    cnt++;
        return cnt;
    }

    //优化版
    //2588. 统计美丽子数组数目
    public long beautifulSubarrays2(int[] nums) {
        int n=nums.length;
        long cnt=0;
        //统计异或值出现次数
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(0,1);
        //xor[i]:前i个数的异或结果
        int[] xor=new int[n+1];
        for(int i=1;i<=n;i++){
            xor[i]=xor[i-1]^nums[i-1];
            if(hash.containsKey(xor[i])) cnt+=hash.get(xor[i]);
            hash.merge(xor[i],1,Integer::sum);
        }
        return cnt;
    }
}