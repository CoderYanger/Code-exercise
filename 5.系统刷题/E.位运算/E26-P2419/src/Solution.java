/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-26
 * Time: 15:42
 */
class Solution {
    //2419. 按位与最大的最长子数组
    public int longestSubarray(int[] nums) {
        int max=1,len=0,ret=1;
        for(int x:nums){
            if(x>max){ max=x;len=1;ret=1;}//ret也要重置
            else if(x==max){len++;ret=Math.max(ret,len);}
            else len=0;//及时断开，避免错误连续
        }
        return ret;
    }
}