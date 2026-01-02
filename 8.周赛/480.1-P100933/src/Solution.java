import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 12:29
 */
class Solution {
    //100933. 最大和最小 K 个元素的绝对差
    public int absDifference(int[] nums, int k) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>((a, b)->b-a);
        int n=nums.length;
        for(int i=0;i<n;i++){
            min.offer(nums[i]);
            max.offer(nums[i]);
        }
        int summin=0,summax=0;
        for(int i=0;i<k;i++){
            summin+=min.poll();
            summax+=max.poll();
        }
        return Math.abs(summax-summin);
    }
}
