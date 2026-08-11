import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-29
 * Time: 18:29
 */
class Solution {
    //628. 三个数的最大乘积
    //解法一：排序
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return Math.max(nums[n-3]*nums[n-2]*nums[n-1],nums[0]*nums[1]*nums[n - 1]);
    }

    //628. 三个数的最大乘积
    //解法二：贪心
    public int maximumProduct(int[] nums) {
        int min1=0x3f3f3f3f;
        int min2=0x3f3f3f3f;
        int max1=-0x3f3f3f3f;
        int max2=-0x3f3f3f3f;
        int max3=-0x3f3f3f3f;
        for(int x:nums){
            //维护最小值和次小值
            if(x<min1){min2=min1;min1=x;}
            else if(x<min2) min2=x;
            //维护前三个最大值
            if(x>max1){max3=max2;max2=max1;max1=x;}
            else if(x>max2){max3=max2;max2=x;}
            else if(x>max3) max3=x;
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
