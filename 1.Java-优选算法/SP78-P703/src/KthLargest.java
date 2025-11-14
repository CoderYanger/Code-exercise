import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-17
 * Time: 23:17
 */
class KthLargest {
    //703. 数据流中的第K大元素
    //吴小哲的思路，多出来的扔掉
    //而我一开始的思路是拿堆顶元素依次换，就涉及到可能压根没有K个数的边界情况，处理很麻烦
    PriorityQueue<Integer> heap=new PriorityQueue<>((a, b)->(a-b));//先建立小根堆
    int _k;//获取长度
    public KthLargest(int k, int[] nums) {
        _k=k;
        for(int x:nums){
            heap.offer(x);
            if(heap.size()>k) heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if(heap.size()>_k) heap.poll();
        return heap.peek();
    }
}