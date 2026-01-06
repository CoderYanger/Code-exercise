import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 18:16
 */
public class Solution {
    //2824. 统计和小于目标的下标对数目
    public int countPairs(List<Integer> nums, int target) {
        //排序：给数组排序用Arrays.sort，给集合排序用Collections.sort
        Collections.sort(nums);
        int left=0,right=nums.size()-1,ret=0;
        while(left<right){
            while(left<right&&nums.get(left)
                    +nums.get(right)>=target) right--;
            ret+=right-left;//统计的是数对，两两一对，所以不用+1
            left++;
        }
        return ret;
    }

}
