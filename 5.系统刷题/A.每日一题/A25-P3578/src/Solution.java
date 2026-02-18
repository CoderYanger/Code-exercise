import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-06
 * Time: 20:15
 */
class Solution {
    //3578. 统计极差最大为 K 的分割方式数
    public int countPartitions(int[] nums, int k) {
        final int MOD=1_000_000_007;
        int n=nums.length;
        //维护单调递增（队首->队尾，nums值从小到大），保证队首是当前窗口的最小值下标
        Deque<Integer> minQ=new ArrayDeque<>();
        //维护单调递减（队首->队尾，nums值从大到小），保证队首是当前窗口的最大值下标
        Deque<Integer> maxQ=new ArrayDeque<>();
        //dp[i]:前i个元素的合法分割方式数
        int[] dp=new int[n+1];
        dp[0]=1;//前0个元素（空数组）只有一种分割方式（不分割）
        long sum=0;//滑动窗口内的dp[left->right]和
        for(int left=0,right=0;right<n;right++){
            //①进窗口（入队）
            //将dp[right]加入sum：当前处理到nums[right],right是候选分割点
            sum+=dp[right];
            int x=nums[right];//当前元素的值
            while(!minQ.isEmpty()&&x<=nums[minQ.peekLast()]) minQ.pollLast();
            minQ.addLast(right);//加入当前下标，维持单调递增
            while(!maxQ.isEmpty()&&x>=nums[maxQ.peekLast()]) maxQ.pollLast();
            maxQ.addLast(right);//加入当前下标，维持单调递减
            //②出窗口（出队）
            while(nums[maxQ.peekFirst()]-nums[minQ.peekFirst()]>k){
                sum-=dp[left++];//left右移，排除不合法的分割点
                //维护minQ和maxQ:若队首下标<left，说明该下标已不在窗口内，移除
                if(minQ.peekFirst()<left) minQ.pollFirst();
                if(maxQ.peekFirst()<left) maxQ.pollFirst();
            }
            //③更新
            dp[right+1]=(int)(sum%MOD);
        }
        return dp[n];
    }
}