import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-08
 * Time: 13:25
 */
class Solution {
    //3835. 开销小于等于 K 的子数组数目
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        Deque<Integer> max=new LinkedList<>();
        Deque<Integer> min=new LinkedList<>();
        long ret=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            //更新窗口内的最值
            while(!max.isEmpty()&&nums[right]>=nums[max.peekLast()]) max.pollLast();
            max.offerLast(right);
            while(!min.isEmpty()&&nums[right]<=nums[min.peekLast()]) min.pollLast();
            min.offerLast(right);
            //出窗口
            while(!max.isEmpty()&&!min.isEmpty()){
                long curmax=nums[max.peekFirst()];
                long curmin=nums[min.peekFirst()];
                long cost=(curmax-curmin)*(right-left+1);
                if(cost>k){
                    if(max.peekFirst()==left) max.pollFirst();
                    if(min.peekFirst()==left) min.pollFirst();
                    left++;
                }else break;
            }
            ret+=right-left+1;
        }
        return ret;
    }
}
