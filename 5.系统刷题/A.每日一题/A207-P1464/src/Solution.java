import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-30
 * Time: 16:04
 */
class Solution {
    //1464. 数组中两元素的最大乘积
    //解法一：排序
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return (nums[n-1]-1)*(nums[n-2]-1);
    }

    //1464. 数组中两元素的最大乘积
    //解法二：维护最大值次大值
    public int maxProduct(int[] nums) {
        int max1=0,max2=0;
        for(int x:nums){
            if(x>max1){max2=max1;max1=x;}
            else if(x>max2) max2=x;
        }
        return (max1-1)*(max2-1);
    }

    //1464. 数组中两元素的最大乘积
    //解法三：枚举右维护左
    public int maxProduct(int[] nums) {
        int ret=0,mx=0;
        for(int x:nums){
            ret=Math.max(ret,(mx-1)*(x-1));
            mx=Math.max(mx,x);
        }
        return ret;
    }
}
