import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-19
 * Time: 13:09
 */
class Solution {
    //2154. 将找到的值乘以 2
    //排序解法
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int x:nums)
            if(x==original)
                original*=2;
        return original;
    }

    public int findFinalValue1(int[] nums, int original) {
        Set<Integer> hash=new HashSet<>();
        for(int x:nums) hash.add(x);
        while(hash.contains(original)) original*=2;
        return original;
    }
}