import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-07-31
 * Time: 20:08
 */
public class Solution {
    //1. 两数之和
    /*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
    你可以按任意顺序返回答案。
    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]
    示例 3：
    输入：nums = [3,3], target = 6
    输出：[0,1]*/
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("请输入数组的长度：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("请输入" + n + "个数放入数组");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("请输入target的值：");
        int target = sc.nextInt();
        int[] result = Solution.twoSum(nums, target);
        System.out.println("数组下标为：[" + result[0] + "," + result[1] + "]");
    }
}
