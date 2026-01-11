import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 18:50
 */
class Solution {
    //3634. 使数组平衡的最少移除数目
    public int minRemoval(int[] nums, int k) {
        //排序+滑动窗口
        Arrays.sort(nums);
        int n=nums.length,left=0;
        int max=0;//记录窗口最大值
        for(int right=0;right<n;right++){
            //进窗口
            //出窗口
            while(k*(long)nums[left]<nums[right])//测试数据的单个元素会int溢出，要转换成long
                left++;
            //更新
            max=Math.max(max,right-left+1);
        }
        return n-max;
    }
}