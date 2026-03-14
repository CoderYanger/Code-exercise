import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 18:07
 */
class Solution {
    //1508. 子数组和排序后的区间和
    private int MOD=1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=nums[i];
            list.add(sum);
            for(int j=i+1;j<n;j++){
                sum+=nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long ret=0;
        for(int i=left-1;i<=right-1;i++)
            ret+=list.get(i);
        return (int)(ret%MOD);
    }
}
