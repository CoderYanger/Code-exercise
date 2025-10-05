import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-21
 * Time: 16:48
 */
class Solution {
    //18. 四数之和
    /*给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
    请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
            0 <= a, b, c, d < n
    a、b、c 和 d 互不相同
    nums[a] + nums[b] + nums[c] + nums[d] == target
    你可以按 任意顺序 返回答案 。
    示例 1：
    输入：nums = [1,0,-1,0,-2,2], target = 0
    输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    示例 2：
    输入：nums = [2,2,2,2,2], target = 8
    输出：[[2,2,2,2]]
    提示：
            1 <= nums.length <= 200
            -109 <= nums[i] <= 109
            -109 <= target <= 109*/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> arr=new ArrayList<>();
        int i=0;
        while(i<nums.length-3){
            int j=i+1;
            while(j<nums.length-2){
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    long total=(long)nums[left]+(long)nums[right]+(long)nums[i]+(long)nums[j];
                    if(total>target) right--;
                    else if(total<target) left++;
                    else if(total==target){
                        List<Integer> row=new ArrayList<>();
                        row.add(nums[i]);
                        row.add(nums[j]);
                        row.add(nums[left]);
                        row.add(nums[right]);
                        arr.add(row);
                        left++;
                        right--;
                    }
                    while(left-1>j&&left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right+1<nums.length-1&&left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                }
                j++;
                while(j<nums.length-2&&nums[j]==nums[j-1]){
                    j++;
                }
            }
            i++;
            while(i-1>=0&&i<nums.length-3&&nums[i]==nums[i-1]){
                i++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums=new int[]{1000000000,1000000000,1000000000,1000000000};
        int target=0;
        System.out.println(s.fourSum(nums,target));
    }
}
