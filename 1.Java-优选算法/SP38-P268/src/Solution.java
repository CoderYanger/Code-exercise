import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-02
 * Time: 23:06
 */
class Solution {
    //268. 丢失的数字
    /*给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
    示例 1：
    输入：nums = [3,0,1]
    输出：2
    解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
    示例 2：
    输入：nums = [0,1]
    输出：2
    解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
    示例 3：
    输入：nums = [9,6,4,2,3,5,7,0,1]
    输出：8
    解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
    提示：
    n == nums.length
1 <= n <= 104
            0 <= nums[i] <= n
    nums 中的所有数字都 独一无二
    进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?*/
    public int missingNumber1(int[] nums) {
        //自己想的解法：先排序再用对应下标相等
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]) return i;
        }
        //前面都对应上了，就缺最后一个数
        return nums.length;
    }
    public int missingNumber2(int[] nums) {
        //吴小哲解法，异或消消乐（自己创造出来再消消乐）
        int ret=0;
        for(int x:nums) ret^=x;
        for(int i=0;i<=nums.length;i++) ret^=i;
        return ret;
    }
    public int missingNumber3(int[] nums) {
        //高斯求和解法
        int sum1=0,sum2=0;
        for(int x:nums) sum1+=x;
        for(int i=0;i<=nums.length;i++) sum2+=i;
        return sum2-sum1;
    }
    public int missingNumber4(int[] nums) {
        //哈希表解法，哪个是0就缺哪个
        int[] hash= new int[nums.length+1];
        for(int i=0;i<nums.length;i++) hash[nums[i]]++;
        for(int i=0;i<hash.length;i++) if(hash[i]==0) return i;
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums={3,0,1};
        Solution solution=new Solution();
        System.out.println(solution.missingNumber4(nums));
    }
}