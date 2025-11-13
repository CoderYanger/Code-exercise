import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-17
 * Time: 21:07
 */
class Solution {
    //1046. 最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a, b)->b-a);//建立大根堆
        for(int x:stones) heap.offer(x);
        while(heap.size()>1){
            int a=heap.poll();
            int b=heap.poll();
            if(a>b) heap.offer(a-b);
        }
        return (heap.isEmpty())?0:heap.poll();
    }
}