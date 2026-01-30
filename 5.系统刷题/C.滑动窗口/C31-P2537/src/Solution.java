import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-11
 * Time: 20:22
 */
class Solution {
    //2537. 统计好子数组的数目
    public long countGood(int[] nums, int k) {
        long ret=0,count=0;
        int left=0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums){
            //进窗口
            int c=hash.getOrDefault(x,0);
            count+=c;
            hash.put(x,c+1);
            //进窗口
            while(count>=k){
                c=hash.get(nums[left]);
                //无论是否是x都要减
                hash.put(nums[left],c-1);
                count-=c-1;
                left++;
            }
            //更新
            ret+=left;
        }
        return ret;
    }
}
