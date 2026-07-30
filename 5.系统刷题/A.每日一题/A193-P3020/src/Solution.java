import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-18
 * Time: 18:37
 */
class Solution {
    //3020. 子集中元素的最大数量
    public int maximumLength(int[] nums) {
        if(nums.length==0) return 0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums) hash.merge(x,1,Integer::sum);
        int mx=1;
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            //特殊处理：1
            if(key==1){
                int n=hash.get(1);
                if(n%2==1) mx=Math.max(mx,n);
                else mx=Math.max(mx,n-1);
                continue;
            }
            if(val==1){
                mx=Math.max(mx,1);
                continue;
            }
            int k=1;
            while(hash.containsKey((int)Math.pow(key,Math.pow(2,k)))){
                mx=Math.max(mx,2*k+1);
                if(hash.get((int)Math.pow(key,Math.pow(2,k)))==1) break;
                k++;
            }
        }
        return mx;
    }
}
