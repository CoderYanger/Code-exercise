import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-20
 * Time: 22:39
 */
class Solution {
    //15. 三数之和
    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    示例 1：
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    解释：
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    注意，输出的顺序和三元组的顺序并不重要。
    示例 2：
    输入：nums = [0,1,1]
    输出：[]
    解释：唯一可能的三元组和不为 0 。
    示例 3：
    输入：nums = [0,0,0]
    输出：[[0,0,0]]
    解释：唯一可能的三元组和为 0 。
    提示：
            3 <= nums.length <= 3000
            -105 <= nums[i] <= 105*/

    //自己按照思路写的，后来按照老师的答案稍作修改
    //注意要先判断再去重，否则- 如果初始的 left 和 right 就有重复，会直接跳过这些重复元素，但此时还没开始找三元组，可能漏掉中间隐藏的有效组合。
    //- 例如：nums = [-2, -2, 0, 2, 2]，i = 0（对应 -2 ），left = 1（也是 -2 ），right = 4（ 2 ）。
    // 先执行 left 去重会直接跳到 left = 2（ 0 ），但原本 (-2, -2, 4) 位置的 2 也能组成有效三元组（-2 + -2 + 4 = 0 ），却被提前跳过了。
    public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> arr=new ArrayList<>();
            Arrays.sort(nums);
            int i=0;
            while(i<nums.length-1&&nums[i]<=0){
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    int sum=nums[left]+nums[right];
                    if(nums[i]>-sum) right--;
                    else if(nums[i]<-sum) left++;
                    else if(sum==-nums[i]) {
                        List<Integer> row=new ArrayList<>();
                        row.add(nums[i]);row.add(nums[left]);row.add(nums[right]);
                        arr.add(row);
                        left++;right--;
                    }
                    while(left-1>i&&left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right+1<nums.length-1&&left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                }
                while(i+1<nums.length&&nums[i]==nums[i+1]) {
                    i++;
                }
                i++;
            }
            return arr;
        }

    public static void main(String[] args) {
        int[] nums={0,0,0,0,0,0,0,0,0};
        Solution solution=new Solution();
        List<List<Integer>> arr=solution.threeSum(nums);
        for(List<Integer> list:arr){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}