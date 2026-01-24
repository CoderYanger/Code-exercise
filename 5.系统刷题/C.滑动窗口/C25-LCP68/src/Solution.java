import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-08
 * Time: 21:41
 */
class Solution {
    //LCP 68. 美观的花束
    public int beautifulBouquet(int[] nums, int k) {
        int n=nums.length,ret=0;
        //存<花类别，数量>
        Map<Integer,Integer> hash=new HashMap<>();
        for(int left=0,right=0;right<n;right++){
            //进窗口
            int in=nums[right];
            hash.put(in,hash.getOrDefault(in,0)+1);
            //出窗口：只有当前新加入窗口的值可能数量超过k，所以没必要再遍历一遍哈希表
            while(hash.get(in)>k){
                int out=nums[left];
                hash.put(out,hash.get(out)-1);
                if(hash.get(out)==0) hash.remove(out);
                left++;
            }
            //更新
            ret+=right-left+1;
        }
        return ret;
    }
}
