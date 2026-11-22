import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-09-01
 * Time: 20:07
 */
class Solution {
    //3731. 找出缺失的元素
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ret=new ArrayList<>();
        Set<Integer> hash=new HashSet<>();
        int mx=0,mn=0x3f3f3f3f;
        for(int x:nums){
            //扔进 Set
            hash.add(x);
            //维护最大值最小值
            if(x>mx) mx=x;
            if(x<mn) mn=x;
        }
        for(int i=mn;i<=mx;i++)
            if(!hash.contains(i))
                ret.add(i);
        return ret;
    }
}
