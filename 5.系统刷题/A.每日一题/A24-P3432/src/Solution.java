/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-05
 * Time: 09:17
 */
class Solution {
    //3432. 统计元素和差值为偶数的分区方案
    public int countPartitions(int[] nums) {
        int sum=0,ret=0;
        for(int x:nums) sum+=x;
        int lsum=0,n=nums.length;
        //不用走到头，因为sum为偶数时会重复计算两次
        for(int i=0;i<n-1;i++){
            lsum+=nums[i];//左子区间的和
            int rsum=sum-lsum;//右子区间的和
            if((lsum-rsum)%2==0) ret++;
        }
        return ret;
    }
}