import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-06
 * Time: 21:28
 */
class Solution {
    //2762. 不间断子数组
    //一开始自己写的代码，以left对应元素为基准取“±2 区间”，只能保证right位置的元素和left的差≤2，但无法保证窗口内其他元素之间的差也≤2
    //比如5为基准时区间是[3,7],3、7与5之间都符合要求，但3和7的差是4，不符合要求
    public long continuousSubarrays(int[] nums) {
        //滑动窗口维护：两两之间数值差<=2的连续子数组
        int n=nums.length;
        int ret=0;
        for(int left=0,right=0;right<n;right++){
            //取标准
            int cur=nums[left];
            int l=cur-2,r=cur+2;
            //进窗口
            if(nums[right]>=l&&nums[right]<=r)
                ret+=right-left+1;
            //出窗口
            if(nums[right]<l||nums[right]>r){
                left=right-1;
                right-=2;
                ret--;
            }
        }
        return ret;
    }

    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minQ=new ArrayDeque<>();
        Deque<Integer> maxQ=new ArrayDeque<>();
        int n=nums.length;
        long ret=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            int x=nums[right];
            //maxQ队首一定是当前窗口的最值：队首最旧最大的元素（单调性保证最值）+窗口范围[left,right]保证在窗口内,minQ同理
            //队列出掉的元素再也用不上：遍历到right时，在当前窗口内的元素就是maxQ里的最大值，旧的最大值就算不出掉也用不上，出掉还能防止干扰，保证最大值最新，minQ同理
            while(!minQ.isEmpty()&&x<=nums[minQ.peekLast()]) minQ.pollLast();
            minQ.addLast(right);
            while(!maxQ.isEmpty()&&x>=nums[maxQ.peekLast()]) maxQ.pollLast();
            maxQ.addLast(right);
            //出窗口
            while(nums[maxQ.peekFirst()]-nums[minQ.peekFirst()]>2){
                left++;
                if(minQ.peekFirst()<left) minQ.pollFirst();
                if(maxQ.peekFirst()<left) maxQ.pollFirst();
            }
            //更新
            ret+=right-left+1;
        }
        return ret;
    }
}