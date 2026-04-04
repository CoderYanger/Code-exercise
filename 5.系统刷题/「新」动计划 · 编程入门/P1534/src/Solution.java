/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:17
 */
class Solution {
    //1534. 统计好三元组
    //14ms击败71.29%
    public int countGoodTriplets(int[] nums, int a, int b, int c) {
        int cnt=0,n=nums.length;
        for(int i=0;i<n-2;i++)
            for(int j=i+1;j<n-1;j++)
                for(int k=j+1;k<n;k++)
                    if(Math.abs(nums[i]-nums[j])<=a&&
                            Math.abs(nums[j]-nums[k])<=b&&
                            Math.abs(nums[i]-nums[k])<=c)
                        cnt++;
        return cnt;
    }
}
