import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-19
 * Time: 14:12
 */
class Solution {
    //3194. 最小元素和最大元素的最小平均值
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=n-1;
        double ret=0x3f3f3f3f;
        while(left<right){
            int tmp=nums[left]+nums[right];
            ret=(double)tmp<ret?(double)tmp:ret;
            left++;right--;
        }
        return ret/2.0;
    }
}
