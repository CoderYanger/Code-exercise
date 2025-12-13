/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-03
 * Time: 20:32
 */
class Solution {
    //674. 最长连续递增序列
    //自己写的时候一直越界，我想用O（N）来解决，但是还是不行
    //还是看的吴小哲的
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length,ret=0;
        for(int i=0;i<n;){
            int j=i+1;
            while(j<n&&nums[j]>nums[j-1]) j++;
            ret=Math.max(ret,j-i);
            i=j;
        }
        return ret;
    }
}
