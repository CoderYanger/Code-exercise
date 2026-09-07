import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:32
 */
class EventManager {
    //3885. 设计事件管理器
    //存储当前活跃事件的envenId→最新优先级，保证数据的最终有效性
    private final Map<Integer,Integer> eventPriorityMap;
    private final PriorityQueue<int[]> heap;
    public EventManager(int[][] events) {
        eventPriorityMap=new HashMap<>();
        //自定义排序：①优先级降序②优先级相同时eventId升序
        heap=new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return b[1]-a[1];
            return a[0]-b[0];
        });
        //初始化事件
        for(int[] event:events){
            int eventId=event[0];
            int priority=event[1];
            eventPriorityMap.put(eventId,priority);
            heap.offer(new int[]{eventId,priority});
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        eventPriorityMap.put(eventId,newPriority);
        heap.offer(new int[]{eventId,newPriority});
    }

    public int pollHighest() {
        //清除堆中无效旧数据
        while(!heap.isEmpty()){
            int[] top=heap.peek();
            int eventId=top[0];
            int heapPriority=top[1];
            //校验堆顶数据是否有效：事件仍活跃且优先级与最新值一致
            if(eventPriorityMap.containsKey(eventId)&&eventPriorityMap.get(eventId)==heapPriority){
                //有效数据：移除事件并返回
                eventPriorityMap.remove(eventId);
                heap.poll();
                return eventId;
            }else{
                //无效数据，直接丢弃
                heap.poll();
            }
        }
        //无活跃事件
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */