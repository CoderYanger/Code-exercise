import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-03
 * Time: 20:36
 */
class Solution {
    //1005. K 次取反后最大化的数组和
    //自己看着算法原理写的，基本上一遍过，就是循环的时候，i>=0写错了，应该为i>0，这样才是m个数
    public int largestSumAfterKNegations(int[] nums, int k) {
        //定义小根堆
        PriorityQueue<Integer> heap=new PriorityQueue<>((a, b)->a-b);
        //统计负数的个数
        int m=0;
        for(int x:nums){heap.offer(x);if(x<0) m++;}
        if(m>=k) for(int i=k;i>0;i--){
            int x=heap.poll();
            heap.offer(-x);
        }else{
            //先把所有负数变成正数
            for(int i=m;i>0;i--){
                int x=heap.poll();
                heap.offer(-x);
            }
            //如果k-m是奇数，挑选当前数组中最小的数变成负数
            if((k-m)%2==1){
                int x=heap.poll();
                heap.offer(-x);
            }
        }
        int ret=0;
        for(int x:heap)ret+=x;
        return ret;
    }

    //吴小哲的解法，感觉没我的那个看着舒服，他是先把正的全累加之后再另减
    //而我是把处理好的放堆里一起统计的，大差不差吧
    public int largestSumAfterKNegations2(int[] nums, int k) {
        int m=0,minElem=Integer.MAX_VALUE,n=nums.length;
        for(int x:nums){
            if(x<0) m++;
            minElem=Math.min(minElem,Math.abs(x));//找到绝对值最小的数，方便后续操作
        }
        int ret=0;
        if(m>k){
            Arrays.sort(nums);
            //前K个负数变成正数
            for(int i=0;i<k;i++) ret+=-nums[i];
            //后面的数不变
            for(int i=k;i<n;i++) ret+=nums[i];
        }else{
            //把负数全变成正数
            for(int x:nums) ret+=Math.abs(x);
            if((k-m)%2!=0) ret-=minElem*2;
        }
        return ret;
    }
}