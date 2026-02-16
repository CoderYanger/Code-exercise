/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-22
 * Time: 11:04
 */
class Solution {
    //3190. 使所有元素都可以被 3 整除的最少操作数
    public int minimumOperations(int[] nums) {
        //%3的结果：0，1，2
        //0：正好被3整除，不用改
        //1：需-1
        //2：需+1
        int ret=0,n=nums.length;
        for(int i=0;i<n;i++)
            if(nums[i]%3==0) continue;
            else ret++;
        return ret;
    }
}