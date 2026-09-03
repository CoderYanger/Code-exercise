/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-16
 * Time: 18:07
 */
class Solution {
    //3871. 统计范围内的逗号 II
    public long countCommas(long n) {
        if(n<1000) return 0;
        long ret=1+n-1000;
        long[] nums={1_000_000L,1_000_000_000L,1_000_000_000_000L,1_000_000_000_000_000L};
        for(long x:nums){
            if(n>=x) ret+=1+n-x;
            else break;
        }
        return ret;
    }
}
