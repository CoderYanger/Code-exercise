/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-14
 * Time: 12:58
 */
class Solution {
    //2784. 检查数组是否是好的
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int[] hash=new int[201];
        int mx=0;
        for(int x:nums){
            mx=Math.max(mx,x);
            hash[x]++;
        }
        for(int i=1;i<mx;i++) if(hash[i]!=1) return false;
        return hash[mx]==2;
    }
}
