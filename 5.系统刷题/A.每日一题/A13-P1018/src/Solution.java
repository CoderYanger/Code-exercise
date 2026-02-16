import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 10:53
 */
class Solution {
    //1018. 可被 5 整除的二进制前缀
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ret=new ArrayList<>();
        int x=0;
        for(int bit:nums){
            //类似123=12*10+3
            x=(x<<1|bit)%5;
            ret.add(x==0);
        }
        return ret;
    }
}