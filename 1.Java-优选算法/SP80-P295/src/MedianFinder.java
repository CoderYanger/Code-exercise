import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-18
 * Time: 20:02
 */
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left=new PriorityQueue<>((a,b)->(b-a));//左边大根堆
        right=new PriorityQueue<>((a,b)->(a-b));//右边小根堆
    }
    public void addNum(int num) {
        int m=left.size(),n=right.size();
        if(m==n){
            if(m==0||num<=left.peek()) left.offer(num);
            else{
                right.offer(num);
                left.offer(right.poll());
            }
        }else{
            if(num<=left.peek()){
                left.offer(num);
                right.offer(left.poll());
            }
            else right.offer(num);
        }
    }

    public double findMedian() {
        if(left.size()==right.size()) return (left.peek()+right.peek())/2.0;
        else return left.peek();//这里全用peek而不是poll，因为后续还可能add
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */