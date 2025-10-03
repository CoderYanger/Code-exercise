import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-19
 * Time: 22:43
 */
public class Solution {
    //611. 有效三角形的个数
    /*给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
    示例 1:
    输入: nums = [2,2,3,4]
    输出: 3
    解释:有效的组合是:
            2,3,4 (使用第一个 2)
            2,3,4 (使用第二个 2)
            2,2,3
    示例 2:
    输入: nums = [4,2,3,4]
    输出: 4
    提示:
            1 <= nums.length <= 1000
            0 <= nums[i] <= 1000*/
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);//先排序
        int n=nums.length;
        int ret=0;
        for(int i=n-1;i>=2;i--){
            int left=0;
            int right=i-1;
            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    ret+=(right-left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ret;
    }
}
