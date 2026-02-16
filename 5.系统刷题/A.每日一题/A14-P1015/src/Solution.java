import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-26
 * Time: 19:27
 */
class Solution {
    //1015. 可被 K 整除的最小整数
    public int smallestRepunitDivByK(int k) {
        int resid=1%k,len=1;//初始值为1
        Set<Integer> set=new HashSet<>();
        set.add(resid);
        while(resid!=0){
            resid=(resid*10+1)%k;
            len++;
            if(set.contains(resid)) return -1;
            set.add(resid);
        }
        return len;
    }
}
