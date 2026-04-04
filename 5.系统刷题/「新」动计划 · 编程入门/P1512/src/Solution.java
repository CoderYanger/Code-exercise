/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:16
 */
class Solution {
    //1512. 好数对的数目
    //0ms击败100.00%
    public int numIdenticalPairs(int[] nums) {
        int[] hash=new int[101];
        for(int x:nums) hash[x]++;
        int ret=0;
        for(int x:hash) ret+=(x>1?x*(x-1)/2:0);
        return ret;
    }
}
