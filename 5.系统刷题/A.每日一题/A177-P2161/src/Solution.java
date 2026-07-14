import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-09
 * Time: 15:54
 */
class Solution {
    //2161. 根据给定数字划分数组
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int cnt=0;//统计等于 pivot 的个数
        List<Integer> prev=new ArrayList<>();
        List<Integer> suff=new ArrayList<>();
        for(int x:nums){
            if(x==pivot) cnt++;
            else if(x<pivot) prev.add(x);
            else suff.add(x);
        }
        //拼接
        int index=0;
        for(int x:prev) nums[index++]=x;
        while(cnt-->0) nums[index++]=pivot;
        for(int x:suff) nums[index++]=x;
        return nums;
    }
}