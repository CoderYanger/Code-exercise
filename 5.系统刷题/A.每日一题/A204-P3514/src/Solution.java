/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-28
 * Time: 16:24
 */
class Solution {
    //3514. 不同 XOR 三元组的数目 II
    public int uniqueXorTriplets(int[] nums) {
        int mx=0;
        for(int x:nums) mx=Math.max(mx,x);
        int u=1<<(32-Integer.numberOfLeadingZeros(mx));
        boolean[] hash=new boolean[u];
        for(int i=0;i<nums.length;i++)
            for(int j=i;j<nums.length;j++)
                hash[nums[i]^nums[j]]=true;
        boolean[] hash2=new boolean[u];
        for(int i=0;i<u;i++){
            if(!hash[i]) continue;//没出现过直接跳过
            for(int j:nums) hash2[i^j]=true;
        }
        int ret=0;
        for(boolean x:hash2) if(x) ret++;
        return ret;
    }
}