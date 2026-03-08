import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-26
 * Time: 08:39
 */
class Solution {
    //1200. 最小绝对差
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        List<List<Integer>> ret=new ArrayList<>();
        Arrays.sort(nums);
        //找到最小绝对值差
        int n=nums.length;
        int mi=0x3f3f3f3f;
        for(int i=1;i<n;i++)
            mi=Math.min(mi,nums[i]-nums[i-1]);
        //筛选出最小绝对值差的元素对
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]==mi){
                List<Integer> tmp=new ArrayList<>();
                tmp.add(nums[i-1]);
                tmp.add(nums[i]);
                ret.add(tmp);
            }
        }
        return ret;
    }
}
