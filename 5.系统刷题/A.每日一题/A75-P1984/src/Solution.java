import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-25
 * Time: 10:01
 */
class Solution {
    //1984. 学生分数的最小差值
    //解法一：排序+滑动窗口
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int ret=0x3f3f3f3f;
        for(int right=k-1,left=0;right<n;right++){
            //进窗口
            //更新
            ret=Math.min(ret,nums[right]-nums[left]);
            //出窗口
            left++;
        }
        return ret;
    }
    //解法二：排序+贪心
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int ret=0x3f3f3f3f;
        for(int i=k-1;i<n;i++)
            ret=Math.min(ret,nums[i]-nums[i-k+1]);
        return ret;
    }
}