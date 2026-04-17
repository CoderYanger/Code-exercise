import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-18
 * Time: 17:20
 */
class Solution {
    //3810. 变成目标数组的最少操作次数
    public int minOperations(int[] nums, int[] target) {
        int n=nums.length;
        int[] diff=new int[n];
        //先计算出哪些是需要修改的
        for(int i=0;i<n;i++)
            diff[i]=target[i]-nums[i];
        //统计需要修改的下标
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(diff[i]!=0) list.add(i);
        //原数组中相同的数可以一起修改，所以只要统计不同的数有多少个即可
        Set<Integer> hash=new HashSet<>();
        for(int x:list) hash.add(nums[x]);
        return hash.size();
    }
}
