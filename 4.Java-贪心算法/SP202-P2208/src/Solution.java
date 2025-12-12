import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-30
 * Time: 09:24
 */
class Solution {
    //2208.将数组和减半的最小操作次数
    //自己写的时候出现的三个问题
    //1.我用的是int,但是这题需要用double
    //2.lambda表达式写成(a,b)->b.compareTo(a),而不是(a,b)->b-a
    //因为nums是int[]类型，跟double不兼容
    //3.while循环里直接-=这个数的一半就行了，而我一开始用循环又统计了一遍，导致超时
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap=new PriorityQueue<>((a, b)->b.compareTo(a));
        //入堆
        double sum0=0.0;
        for(int x:nums){sum0+=(double)x;heap.add((double)x);}
        sum0/=2.0;
        double sum=0.0;
        for(double x:heap) sum+=x;
        int ret=0;
        while(sum>sum0){
            double t=heap.poll();
            t/=2.0;
            heap.offer(t);
            sum-=t;
            // for(double x:heap) sum+=x;
            ret++;
        }
        return ret;
    }
}